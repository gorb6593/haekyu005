23-08-05 => 프로젝트, 이력서 정리하기
23-08-15 => 마무리하기


AWS => 과정, aws 아키텍처설명
JAVA => 버전, 로직 설명
DB => 과정 설명, 타입, latin1등 설명 적기
프로젝트 설명 => mvc패턴 spirng부트 등

리눅스 자바 17버전 설치
wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.rpm
sudo rpm -ivh jdk-17_linux-x64_bin.rpm
sudo alternatives --config java
java -version

hostname 변경
hostnamectl set-hostname "변경할 이름" 

깃 설치
sudo yum instal git

mkdir ~/app && mkdir ~/app/step1

cd ~/app/step1

git clone "주소"

./gradlew build(안되면 권한 주기 sudo chmod +x gradlew)

해당프로젝트 => build > libs 에 jar파일 생성확인 후 실행

java -jar 프로젝트명.jar





 
