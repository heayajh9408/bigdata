#######################################################
# # # # # 빅데이터 분석 결과 시각화 사례 연구 # # # # #
#######################################################

library(ggplot2)
library(dplyr)  
library(doBy)
library(readxl)

# 1.  ‘한국복지패널데이터’(SPSS, koweps_hpc10_2015_beta5.sav)를 로드한 후 필요한 데이터 변수만을 select하여 변수명을 변경하시오. 
# 단 필요한 필드로 성별은 gender, 태어난 연도는 birth, 혼인상태는 marriage, 종교는religion, 월평균임금은 income, 직업코드는 code_job, 
# 지역코드는 code_region로 필드명을 변경한다.

getwd()

install.packages("foreign") # read.spss() 함수 사용 목적
library(foreign)
raw_welfare <- read.spss(file = 'inData/Koweps/Koweps_hpc10_2015_beta1.sav', 
                         to.data.frame = T) # 이 파라미터 설정이 없다면 list형태로 받아옴
View(raw_welfare)
raw_welfare
welfare <- raw_welfare
dim(welfare)


welfare <- rename(welfare, gender=h10_g3,    # 성별
                  birth = h10_g4,         # 태어난 연도
                  marriage=h10_g10,       # 혼인상태
                  religion = h10_g11,     # 종교
                  income = p1002_8aq1,    # 월급 
                  code_job = h10_eco9,    # 직업코드
                  code_region = h10_reg7) # 지역코드
welfare <- welfare %>% 
  select(gender, birth, marriage, religion, 
         income, code_job, code_region)

welfare$income
View(welfare)

# 2. 1번 문제의 결과인 data.frame변수를 이용하여 성별에 따른 월급 차이가 있는지를 분석하시오. 

str(welfare)         
welfare$gender
# 2.1 이상치 값처리
table(welfare$gender, useNA = "ifany") # 이상치 없음
# 2.2 결측치 확인
table(is.na(welfare$gender))
# 2.3 gender의 값이 1은 male로 2는 female로 변경하고 gender의 타입을 factor로 변경한다
welfare$gender <- factor(welfare$gender, levels = c(1,2), labels = c('male','female'))

str(welfare)

# 2.4 성별 비율 도표와 그래프 시각화
welfare %>% 
  group_by(gender) %>% 
  summarise(ratio=n()/nrow(welfare)*100) # 성별 비율

# 그래프로
welfare %>% 
  group_by(gender) %>% 
  summarise(ratio=n()/nrow(welfare)*100) %>% 
  ggplot(aes(x=gender, y=ratio, fill=gender))+
  geom_bar(stat = 'identity')

welfare %>% 
  group_by(gender) %>% 
  summarise(ratio=n()/nrow(welfare)*100) %>% 
  ggplot(aes(x=gender, y=ratio))+
  geom_col(aes(fill=gender))+
  labs(title='남녀 성비')

# 2.5  income의 최소값, 1분위수, 중위수, 3분위수, 최대값, 결측치 등을 탐색하고, boxplot과 월급의 빈도그래프를 시각화한다

summary(welfare$income)

qplot(welfare$income)
qplot(welfare$income, xlim = c(0,1000))
ggplot(welfare, aes(income))+
  geom_histogram()+
  coord_cartesian(xlim=c(0,1000))

# 2.6 이상치를 결측처리
boxplot(welfare$income)
bp <- boxplot(welfare$income)$stat
bp
table(welfare$income<=bp[1], useNA = "ifany") # 하위 이상치를 벗어난 값
table(welfare$income > bp[5],exclude = NULL) # 상위 이상치를 벗어난 값이 5%이상의 값이여서 상위 이상치는 이상치 처리하지 않는다.

welfare$income <- ifelse(welfare$income<=bp[1], NA, welfare$income)

table(welfare$income1==bp[1], useNA = "ifany") # 이상치 처리 된었는지 학인
table(welfare$income==bp[1], useNA = "ifany")
table(is.na(welfare$income))
summary(welfare$income) # 하위 이상치만 처리한 데이터

# 2.7 성별에 따른 월급 차이 분석을 도표로

temp <- welfare[, c('income','gender')]
temp <- na.omit(temp)
summary(temp)
summaryBy(income~gender, temp, FUN = c(mean, sd))

welfare %>% 
  group_by(gender) %>% 
  summarise(mean=mean(income,na.rm=T),
            sd=sd(income, na.rm=T))
# 2.7 성별에 따른 월급 차이가 있는지 그래프로 분석

ggplot(welfare, aes(x=gender, y=income)) +
  geom_violin()+
  geom_point(position = 'jitter', col='yellow', alpha=0.3)+
  geom_boxplot(aes(fill=gender), notch = T, width=0.3)+
  geom_rug(col='dimgray')+
  labs(title = "하위 이상치 처리 후 성별에 따른 수입 분석")+
  coord_cartesian(ylim = c(0,1000))

# 2.7 성별에 따른 월급차이가 있는지 통계적 분석
temp<- welfare %>% filter(!is.na(income))
var.test(income~gender, data = temp)
t.test(income~gender, data =temp, var.equal=F)


# 성별에 따른 월급차이가 없다는 가설을 기각한다



# 문제3.  1번 문제의 결과인 data.frame변수를 이용하여 나이와 월급의 관계를 분석하여 몇 살 때 월급을 가장 많이 받는지 시각화하시오.

# 3.1  birth, income 필드 변수의 이상치와 결측치를 확인한다
b<-boxplot(welfare$birth)$stat
table(welfare$birth)
table(is.na(welfare$birth))
table(welfare$income<=0)
table(is.na(welfare$income))

# 3.2 birth변수를 이용하여 나이를 계산하고 이 값을 age 필드로 추가한다
welfare<- welfare %>% 
  mutate(age=2015-birth+1)
head(welfare)

# 3.3  x축을 나이, y축을 월급으로 지정하고 나이에 따른 월급의 변화가 표현되도록 막대그래프나 선 그래프로 시각화한다
age_income <- welfare %>% 
  filter(!is.na(welfare$income)) %>% 
  group_by(age) %>% 
  summarise(income.mean= mean(income),
            income.sd= sd(income))
ggplot(age_income, aes(x=age, y=income.mean))+
  geom_bar(stat = 'identity')

# 3.4 나이에 따른 월급의 차이가 있는지 관계를 분석한다
# 3.4 도표분석
welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(age) %>% 
  summarise(mean=mean(income, na.rm = T),
            income_sd=sd(income, na.rm = T))

# 3.5 그래프로 분석
ggplot(welfare, aes(x=age, y=income))+
  geom_violin()+
  geom_point(position = 'jitter', col='lightyellow', alpha=0.5)+
  geom_boxplot(aes(fill=age), notch = T, width=0.2)

summary(welfare$income)

result <- aov(income~age, data = welfare)
summary(result)

# 3.5 월급을 가장 맣이 받는 나이대
age_income %>% 
  arrange(-income.mean) %>% 
  head(5) # 53세에 가장 월급이 많음


# 나이에 따른 월급변화가 없다는 가설을 기각한다

# 문제4. 1번 문제의 결과인 data.frame변수를 이용하여 연령대에 따른 월급의 차이가 있는지, 있으면 어떤 연령대가 
# 월급이 가장 많은지 분석하시오. 단, 연령대는 30세 이하는 young, 30~60세는 middle, 61세 이상은 old로 분류한다

# 4.1 파생변수 agegrade를 필드로 추가한다
welfare<- welfare %>% 
  mutate(agegrade=ifelse(age<=30,'young',ifelse(age>30 & age<=60, 'middle', 'old')))
table(welfare$agegrade)
View(welfare)
# 4.2  agegrade 의 분포를 도표와 그래프로 시각화한다
welfare %>% 
  group_by(agegrade) %>% 
  summarise(ratio=n()/nrow(welfare)*100)

welfare %>% 
  group_by(agegrade) %>% 
  summarise(ratio=n()/nrow(welfare)*100) %>% 
  ggplot(aes(x=agegrade, y=ratio, fill=agegrade))+
  geom_bar(stat = 'identity')+
  scale_x_discrete(limits=c('young', 'middle', 'old'))+
  theme(legend.position = 'none')

# 4.3  연령대 별 월급의 boxplot을 시각화한다
welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(agegrade) %>% 
  ggplot(aes(x=agegrade, y=income, fill=agegrade))+
  geom_boxplot(notch = T)+
  coord_cartesian(ylim = c(0,700))+
  scale_x_discrete(limits=c('young', 'middle', 'old'))

# 4.4 실제로 연령대에 따른 월급 차이가 있는지 분석한다
welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(agegrade) %>% 
  summarise(mean=mean(income),
            sd=sd(income))

ggplot(welfare, aes(x=agegrade, y=income))+
  geom_violin()+
  geom_point(position = 'jitter', col='yellow', alpha=0.7)+
  geom_boxplot(aes(fill=agegrade), notch = T, width=0.4)+
  coord_cartesian(ylim = c(0,400))+
  scale_x_discrete(limits=c('young', 'middle', 'old'))

temp <- welfare %>% filter(!is.na(income))
result <- aov(income ~ agegrade, data = temp)
summary(result)

# 연령대에 따른 월급 차이가 없다는 가설을 기각한다

# 문제5. 1번 문제의 결과인 data.frame변수를 이용하여 성별에 따른 월급의 차이는 연령대 별로 다른지 분석하시오.

# 5.1 성별, 연령대, 월급 데이터의 결측치를 확인한다
table(is.na(welfare$gender))
table(is.na(welfare$agegrade))
table(is.na(welfare$income))
# 5.2 연령대별, 성별 월급의 평균과 표준편차, 빈도를 출력한다


gender_agegrade_income<-welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(agegrade, gender) %>% 
  summarise(mean= mean(income),
            sd= sd(income),
            n=n())
gender_agegrade_income

# 5.3 성별에 따른 월급의 차이가 연령대별로 다른지 시각화 한다
welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(agegrade, gender) %>% 
  summarise(mean= mean(income, na.rm=T),
            sd= sd(income, na.rm = T),
            n=n()) %>% 
  ggplot(aes(x=gender, y=mean, fill=gender))+
  geom_bar(stat = 'identity')+
  facet_wrap(~agegrade)

# 문제 6. 1번 문제의 결과인 data.frame변수를 이용하여 나이에 따른 월급 변화를 성별을 분리하여 시각화 하시오. 

# 6.1  나이와 성별로 group_by하여 월급평균, 월급표준편차, 월급중앙값, 최소값과 최대값, 빈도을 산출 한다
welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(gender, age) %>% 
  summarise(mean=mean(income),
            sd = sd(income),
            median= median(income),
            min= min(income),
            max= max(income),
            n=n())

# 6.2  나이에 따른 월급평균의 추이를 아래와 같은 그래프를 시각화하고, 아래의 그래프를 파일로도 출력한다

welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(gender, age) %>% 
  summarise(mean=mean(income),
            sd = sd(income),
            median= median(income),
            min= min(income),
            max= max(income),
            n=n()) %>% 
  ggplot(aes(x=age, y=mean, col=gender))+
  geom_line()

# 문제 7. 1번 문제의 결과인 data.frame변수를 이용하여 직업별 월급의 차이가 나는지 분석하고, 만약 월급의 차이가 나면 
#         어떤 직업이 월급이 가장 많은지 상위 10개 직업군만 시각화하시오.


# 7.1 직업별 월급 평균, 표준편차, 빈도를 평균월급 순으로 정렬하여 출력하여 직업별 월급의 추이를 분석한다
table(is.na(welfare$code_job))
welfare %>% 
  filter(!is.na(code_job)) %>% 
  group_by(code_job) %>% 
  summarise(income.mean= mean(income),
            income.sd= sd(income),
            n=n()) %>% 
  arrange(-income.mean)

# 7.2 직업별 월급의 차이를 분석한 후, 상위 소득 10개 직업군을 도표로 출력하고, 아래와 같은 그래
#     시각화한다. 시각화한 그래프는 ggsave함수를 이용하여 top10.png라는 그림파일로 저장

ggplot(welfare, aes(x=code_job, y=income))+
  geom_bar(stat = 'identity')

result<- aov(income~ code_job, data = welfare)
summary(result)

# 직업에 따라 월급의 차이가 없다는 가설을 기각한다

job <- read_excel('inData/Koweps/Koweps_Codebook.xlsx')
View(job)
temp <-left_join(welfare, job, by='code_job')
View(temp)

temp %>% 
  filter(!is.na(job) & !is.na(income)) %>% 
  group_by(job) %>%
  summarise(income.mean= mean(income),
            income.sd= sd(income),
            n=n()) %>% 
  arrange(-income.mean) %>% 
  head(10) %>% 
  ggplot(aes(y=reorder(job,income.mean), x=income.mean))+
  geom_bar(stat = 'identity')+
  labs(title = "상위 소득 10개 직업군",
       x= "직업", y= "평균소득")
ggsave('outData/top10.png')
# 7.3 하위 소득 10개 직업군도 도표로 출력하고 시각화한다
temp %>% 
  filter(!is.na(job) & !is.na(income)) %>% 
  group_by(job) %>%
  summarise(income.mean= mean(income),
            income.sd= sd(income),
            n=n()) %>% 
  arrange(-income.mean) %>% 
  tail(10) %>% 
  ggplot(aes(y=reorder(job,income.mean), x=income.mean))+
  geom_bar(stat = 'identity')+
  labs(title = "하위 소득 10개 직업군",
       x= "직업", y= "평균소득")

ggsave('outData/bottom10.png')

# 문제 8. 1번 문제의 결과인 data.frame변수를 이용하여 성별로 어떤 직업이 가장 많을지 분석하시오.

job <- read_excel('inData/Koweps/Koweps_Codebook.xlsx')
View(job)
temp <-left_join(welfare, job, by='code_job')
View(temp)

# 여성 최빈 직업 상위 10를 추출한다
temp %>% 
  filter(!is.na(job) & gender=='female') %>% 
  group_by(job) %>% 
  summarise(n=n()) %>% 
  arrange(-n) %>% 
  head(10) %>% 
  ggplot(aes(x=n, y=reorder(job,n)))+
  geom_bar(stat = 'identity')

# 남성 최빈 직업 상위 10를 추출한다
temp %>% 
  filter(!is.na(job)& gender=='male') %>% 
  group_by(job) %>% 
  summarise(n=n()) %>% 
  arrange(-n) %>% 
  head(10) %>% 
  ggplot(aes(x=n, y=reorder(job, n)))+
  geom_bar(stat = 'identity')


# 문제 9.  1번 문제의 결과인 data.frame변수를 이용하여 종교 유무에 따른 이혼률을 분석하시오. 
# 9.1 종교 데이터인 religion 필드의 이상치 및 결측치를 확인한다
boxplot(welfare$religion)
table(is.na(welfare$religion))

# 9.2 religion 필드가 1이면 “종교-유”, 2이면 “종교-무”로 데이터를 변경한다
welfare$religion <- factor(ifelse(welfare$religion==1, '종교-유', '종교-무'))
str(welfare$religion)

# 9.3  종교 유무의 빈도를 시각화한다
welfare %>% 
  group_by(religion) %>% 
  summarise(n=n()) %>% 
  ggplot(aes(x=religion, y=n, fill=religion))+
  geom_bar(stat = 'identity')

# 9.4  혼인 상태 데이터인 marriage 필드가 1이면 “기혼”, 3이면 “이혼”으로, 그 외는 NA로 값을 같은 marriage_group 파생변수를 추가한다
temp<- welfare %>% 
  mutate(marriage_group=ifelse(marriage==1, "기혼", ifelse(marriage==3, "이혼", NA)))
# 9.5 종교 유무에 따른 이혼률을 분석한다
tempmarry <- temp %>% filter(!is.na(marriage_group) & !is.na(religion))
table(tempmarry$religion, tempmarry$marriage_group)

religion_marriage  <- tempmarry %>%
  filter(!is.na(marriage_group)) %>%
  group_by(religion, marriage_group) %>%
  summarise(n = n()) %>%
  mutate(tot_group = sum(n)) %>%
  mutate(pct = round(n/tot_group*100,1))
religion_marriage

# 9.6 분석한 결과를 도표와 그래프로 시각화한다

ggplot(religion_marriage, aes(x=religion, y=n, fill=marriage_group)) + 
  geom_col(position = "dodge")

var.test(data=tempmarry, marriage~religion)
t.test(data=tempmarry, marriage~religion, var.equal=F) 

#p-value가 0.045로 종교유무에 따라 결혼상태가 다소 다를 수 있다.



# 문제 10. 1번 문제의 결과인 data.frame변수를 이용하여 지역별 연령대 비율을 분석하시오. 노년층이 많은 지역은 어디인지 출력하시오

# 10.1 결측치를 확인한다
table(welfare$code_region, useNA = "ifany")
table(!is.na(welfare$agegrade))
table(!is.na(welfare$code_region))


# 10.2  region 파생변수를 지역명으로 추가한다
ten<-welfare %>% 
  mutate(region=ifelse(code_region==1, '서울', ifelse(code_region==2, '수도권(인천/경기)', ifelse(code_region==3, '부산/경남/울산',
                                                                                         ifelse(code_region==4, '대구/경북', ifelse(code_region==5, '대전/충남', 
                                                                                                                                ifelse(code_region==6, '강원/충북', '광주/전남/ 전북/제주도')))))))
ten
# 10.3 지역별 연령대 비율을 분석한 도표 및 그래프를 시각화한다

region_agegrade<-ten %>% 
  group_by(region, agegrade) %>% 
  summarise(n = n()) %>%   # 지역별, 연령별 인구
  mutate(tot_group = sum(n)) %>% # 지역별 인구
  mutate(pct = round(n/tot_group*100, 2)) # 지역별 연령대  percent

region_agegrade


ggplot(data=region_agegrade, aes(x=reorder(region, n), y=n, fill=agegrade)) + 
  geom_col(position = 'dodge') +
  theme(axis.text.x = element_text(angle = 70, vjust=0.7))

ggplot(data=region_agegrade, aes(x=reorder(region, n), y=pct, fill=agegrade)) + 
  geom_col(position = 'dodge') +
  theme(axis.text.x = element_text(angle=70, vjust=0.5))


# 노년층이 많은 지역이 어디인지 시각화한다


oldagegrade_region <- region_agegrade %>%
  filter(agegrade=='old') %>%
  arrange(desc(pct))
oldagegrade_region
ggplot(data=oldagegrade_region, 
       aes(x = pct, y=reorder(region, pct))) +geom_col()



