# 프리온보딩 백엔드 인턴십 선발과제
## README 에 요구사항 분석 및 구현 과정을 작성
## 요구사항 분석

<img src="./readme_img/1/Object_modeling.PNG">

<img src="./readme_img/1/ERD_modeling.png">

## 구현과정
1. 전체적인 흐름을 보고 필요한 Entity부터 설계
2. Entity 설계 후 Repository -> Service -> ServiceImpl -> Contorller 순으로 추가 및 커밋
3. 채용공고 등록 작성

    #### RecruitmentService
    <img src="./readme_img/2/1_1.PNG">

    #### RecruitmentServiceImpl
    <img src="./readme_img/2/1_2.PNG">

    #### ApiController
    <img src="./readme_img/2/1_3.PNG">

    ### 등록 성공시
    <img src="./readme_img/2/1_4.PNG">
    <img src="./readme_img/2/1_5.PNG">

        양식
        {
        "company":{"comId" : "회사이름" },
        "position" : "포지션",
        "money" : 보상금,
        "contnt" : "내용",
        "skill" :"스킬"
        }

    ### 등록 실패시
    <img src="./readme_img/2/1_6.PNG">    

4. 채용공고수정 작성
    #### RecruitmentService
    <img src="./readme_img/2/2_1.PNG">

    #### RecruitmentServiceImpl
    <img src="./readme_img/2/2_2.PNG">

    #### ApiController
    <img src="./readme_img/2/2_3.PNG">

    ### 수정 성공시
    <img src="./readme_img/2/2_4.PNG">
    <img src="./readme_img/2/2_6.PNG">

    ### 수정 실패시
    <img src="./readme_img/2/2_5.PNG">    

5. 채용공고 삭제
    #### RecruitmentService
    <img src="./readme_img/2/3_1.PNG">

    #### RecruitmentServiceImpl
    <img src="./readme_img/2/3_2.PNG">

    #### ApiController
    <img src="./readme_img/2/3_3.PNG">

    ### 삭제 성공시
    <img src="./readme_img/2/3_4.PNG">
    <img src="./readme_img/2/3_5.PNG">

    ### 삭제 실패시
    <img src="./readme_img/2/3_6.PNG">    

6. 채용공고목록
    #### RecruitmentRepository
    <img src="./readme_img/2/4_0.PNG">

    #### RecruitmentService
    <img src="./readme_img/2/4_1.PNG">

    #### RecruitmentServiceImpl
    <img src="./readme_img/2/4_2.PNG">

    #### ApiController
    <img src="./readme_img/2/4_3.PNG">

    ### 목록조회
    <img src="./readme_img/2/4_4.PNG">

7. 채용공고 검색 기능구현
    #### RecruitmentsVO
    <img src="./readme_img/2/RecruitmentVO.PNG">

    #### RecruitmentRepository
    <img src="./readme_img/2/5_0.PNG">

    #### RecruitmentService
    <img src="./readme_img/2/5_1.PNG">

    #### RecruitmentServiceImpl
    <img src="./readme_img/2/5_2.PNG">

    #### ApiController
    <img src="./readme_img/2/5_3.PNG">

    ### 검색조회
    <img src="./readme_img/2/5_4.PNG">

8. 채용 상세 페이지 + 다른채용공고
    #### RecruitmentDetailVO - 상세
    <img src="./readme_img/2/detailVO.PNG">

    #### RecruitmentDetailListVO - 리스트추가
    <img src="./readme_img/2/detailListVO.PNG">

    #### RecruitmentRepository
    <img src="./readme_img/2/6_0.PNG">

    #### RecruitmentService
    <img src="./readme_img/2/6_1.PNG">

    #### RecruitmentServiceImpl
    <img src="./readme_img/2/6_2.PNG">

    #### ApiController
    <img src="./readme_img/2/6_3.PNG">

    #### 조회 테스트 전 DB
    <img src="./readme_img/2/6_before.PNG">

    #### 상세조회
    <img src="./readme_img/2/6_4.PNG">

9. 사용자는 채용공고에 지원합니다
    #### HistoryRepository
    <img src="./readme_img/2/7_0.PNG">

    #### RecruitmentService
    <img src="./readme_img/2/7_1.PNG">

    #### RecruitmentServiceImpl
    <img src="./readme_img/2/7_2.PNG">

    #### ApiController
    <img src="./readme_img/2/7_3.PNG">

    #### HistoryDTO
    <img src="./readme_img/2/HistoryDTO.PNG">

    #### 지원
    <img src="./readme_img/2/7_4.PNG">

    #### 이미 지원한 공고 일 경우
    <img src="./readme_img/2/7_5.PNG">