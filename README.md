# 로그인 게시판 프로젝트
 스프링부트 프레임워크를 사용하여 로그인과 게시판 기능을 구현한다

## 개요
- 프로젝트 명 : LoginBoard
- 개발기간 : 2024.01.03 ~ 2024.01.19
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
![image](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/4828d094-9c76-4f5c-8df6-96ed2b8c56a6)

###### 회원가입시 유효성 검사를 진행하여 회원가입을 진행함(회원가입시 비밀번호는 암호화후 DB에 저장된다.)

#### 2.로그인 화면
![스크린샷 2024-01-30 153509](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/8a0b394c-99fb-4054-b0d3-cbfdb2e6219e)
![스크린샷 2024-01-11 215217](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/4726949d-7a8f-4035-9fd1-8b7a0ea11347)
##### 로그인시 아이디/비밀번호 검사를 진행하여 로그인을 진행함

#### 2-1 Oauth2 화면 (소셜로그인)
![스크린샷 2024-01-11 215421](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/4a129c0c-4271-441e-a163-3afc79c00e37)

</details>


<details>
<summary>게시판 실행화면</summary>

 #### 1.게시판 전체목록

 ![스크린샷 2024-01-31 221715](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/af561905-b251-46e0-8360-88d56cf58f0d)
##### 페이징 처리와 전체목록을 확인할 수 있다.
 
#### 2.게시글 등록
![스크린샷 2024-01-31 221039](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/0822cfa0-72a1-43a3-9463-a42fe186076c)
##### 로그인한 사용자만 게시글을 작성할 수 있고 비로그인 사용자가 글쓰기 버튼을 클릭시 로그인 화면으로 넘어간다.

#### 3.게시글 상세화면
![스크린샷 2024-01-31 222320](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/df1c2cd2-0055-42f1-a268-58f80e8bb90e)
##### 글을 작성한 사용자가 아닌 다른 사용자가 상세보기 접근시 리스트 버튼만 나타난다.

![스크린샷 2024-01-31 222804](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/26414a78-9a53-4a5c-b901-76e8592f7d58)
##### 글을 작성한 사용자와 일치할시 수정 삭제버튼이 나타난다.

#### 4.게시글 수정화면
![스크린샷 2024-01-31 223156](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/e2ed9151-1c6d-479f-a68a-81e5a03ad762)
![스크린샷 2024-01-31 223218](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/6236d3de-fdbe-43f3-8cfc-159115d556b5)
##### 글을 수정시 제목과 내용만 수정이 가능하고 수정버튼을 클릭시 수정된 게시판 상세보기화면으로 넘어간다. 

#### 5.게시글 삭제화면
![스크린샷 2024-01-31 223811](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/6e09a19e-012c-4ed6-80cb-122ff0e6d7ba)
##### 삭제버튼을 클릭시 삭제확인 여부를 확인하고 삭제를 진행한다.
</details>

<details>
<summary>댓글 실행화면</summary>

#### 1.댓글 작성화면
![image](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/19c36a03-6c84-4395-8af1-2bd9700aea41)
![image](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/0dc9896b-2821-412c-972c-39049c8eb3fc)
##### 댓글을 작성한 사용자만 수정,삭제 버튼이 나타난다.

#### 2.댓글 수정화면
![image](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/df33c7a5-9f56-430d-9063-0b69076d703e)
![image](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/5c47c33b-4585-4ddb-a9f6-dd5f9237e312)
##### 댓글 수정버튼 클릭시 수정할 수 있는 칸이 나타나고 수정을 진행한다.

#### 3.댓글 삭제화면
![image](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/8f01a3dc-8ba8-447b-8c3f-38e5b9d7f23b)
##### 댓글 삭제버튼 클릭시 삭제확인 여부를 확인하고 삭제를 진행한다.

</details>

## DB설계

![스크린샷 2024-01-31 231517](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/8b6caf8a-c060-4871-ab83-1000415dbde5)

### 1.User_table
![image](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/36073e05-d275-4949-ab45-1832b8efe364)


### 2.Board
![image](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/475723c7-ddb9-4d15-8714-de67b2acedcf)


### 3.Comment
![image](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/2352f5e6-c63d-4d0c-9dc5-ce621cad57d6)


### 4.Board_Image
![image](https://github.com/kimhyunkyuo/LoginBoard/assets/131740127/c8078d79-5967-451e-a09f-065affde9615)





