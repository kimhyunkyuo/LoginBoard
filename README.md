# 로그인 게시판 프로젝트
 스프링부트 프레임워크를 사용하여 로그인과 게시판 기능을 구현한다

## 개요
- 프로젝트 명 : LoginBoard
- 개발기간 : 2023.01.03 ~ 2023.01.19
- 개발인원 :  1명
- 주요기능
   - SpringSecurity 회원가입 및 로그인
   - Oauth2로그인 (구글 소셜로그인 구현) 
   - 게시판 - CRUD기능, 페이징 처리
   - 댓글  - CRUD기능 
## 사용기술
### #Back-End
#### core
- java  17
- SpringBoot
- SpringSecurity
- Spring Data JPA
- OAuth2.0
#### BuildTool
- Gradle
#### DataBase
- MySQL

### #Front-End
- JavaScript
- BootStrap
- Thymeleaf

## 개발환경
- IntelliJ
- DBeaver
- Github
---
## 실행화면
<details>
<summary>메인 실행화면</summary>

#### 1.비로그인 메인화면

 ![스크린샷 2024-01-11 214959](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/2bcadb1d-6284-4ee8-83c9-084886fccc44)

 #### 2.로그인 메인화면 (로그인 완료시 마이페이지와 로그아웃 버튼으로 변경됨)
![스크린샷 2024-01-30 125809](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/f41c0c05-dc9d-4a56-9e4e-d3cf02ef667e)

</details>

<details>
<summary>로그인 실행화면</summary>

#### 1.회원가입 화면

![스크린샷 2024-01-11 215235](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/31f7b692-c1f8-4beb-9ca8-7d9ab58fa8fa)
![스크린샷 2024-01-30 143332](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/e956e0f8-e5d4-40d6-bc77-a94936f0f658)
###### 회원가입시 유효성 검사를 진행하여 회원가입을 진행함

#### 2.로그인 화면
![스크린샷 2024-01-30 153509](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/8a0b394c-99fb-4054-b0d3-cbfdb2e6219e)
![스크린샷 2024-01-11 215217](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/4726949d-7a8f-4035-9fd1-8b7a0ea11347)
##### 로그인시 아이디/비밀번호 검사를 진행하여 로그인을 진행함

#### 2-1 Oauth2 화면 (소셜로그인)
![스크린샷 2024-01-11 215421](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/4a129c0c-4271-441e-a163-3afc79c00e37)

</details>
