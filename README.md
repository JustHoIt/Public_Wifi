#  Public_Wifi
## 서울시 공공와이파이 서비스 위치 정보를 활용한 근처 와이파이 찾기

#### 서울시 공공와이파이 서비스 위치 정보를 이용하여 API를 호출하여 데이터를 DB에 저장 후 좌표를 입력하여 입력한 좌표로부터 가까운 와이파이 20개를 검색할 수 있는 기능을 구현하였습니다.

### JAVA 8, JavaScript, HTML/CSS, SQLITE, Intelli J 를 사용하였습니다. 

### 구현한 기능
- 서울시 공공와이파이 서비스 위치 정보 API 를 데이터베이스에 저장하는 기능
- 검색한 좌표와 검색한 시간 히스토리를 데이터베이스에 저장하고 보여주는 기능
- 저장된 검색 히스토리를 데이터베이스에서 삭제하는 기능
- 좌표를 입력하여 좌표로부터 가까운 공공 와이파이 20개를 저장된 데이터베이스로부터 보여주는 기능
- 저장된 히스토리와 불러온 와이파이 리스트를 클릭하면 와이파이의 주변지도를 보여주는 기능(Kakao api활용)

##### exerd파일과 db파일은 Etc폴더에 첨부하였습니다.