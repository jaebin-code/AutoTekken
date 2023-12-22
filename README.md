# AutoTekken

<img src="assets/thumbnail.jpg" alt="이미지 설명" width="300" height="auto">
# 실시간 격투 게임 (Real-Time Fighting Game)
### 프로젝트 소개:

"실시간 격투 게임"은 다중 스레딩, 난수 생성을 통한 확률 활용, 객체지향 프로그래밍 (OOP)을 기반으로 하는 Java 언어로 구현된 게임입니다. 이 게임은 턴 기반 게임이 아닌 병렬 실시간 전투를 목표로 하여 다중 스레딩을 이용하여 구현되었습니다. 각 스레드는 공격 속도를 조절하여 실행되며, 결과적으로 게임은 턴 기반이 아닌 실시간 진행되어 Tekken과 같은 격투 게임과 유사한 경험을 제공합니다. 또한, 각 공격을 확률적으로 선택하기 위해 난수 생성을 구현하여 공격 성공 또는 실패에 따른 대화를 즐길 수 있습니다.

### 기술적 특징 및 프로젝트 구성:

1. 다중 스레딩 (Multithreading): 병렬적이고 실시간적인 전투 경험을 구현하기 위해 각 전투를 별도의 스레드로 실행하였습니다.
2. 객체지향 프로그래밍 (OOP): 인터페이스, 추상 클래스, 다형성, 상속 등을 이용하여 Fighter 클래스의 하위 클래스를 구현하고, Player 클래스를 활용하여 다양한 종류의 전투기를 일관되게 처리할 수 있었습니다.
3. GUI 구현: SWING 라이브러리를 사용하여 게임의 다양한 상호작용을 시각적으로 표현하고 사용자에게 몰입감을 제공하기 위해 Progress Bar와 TextArea를 중심으로 GUI를 설계하였습니다.
4. 예외 처리 및 파일 입출력 활용: 사용자 입력에 대한 에러를 적절히 처리하기 위해 예외를 정의하였으며, 파일 입출력을 통해 사용자가 생성한 캐릭터 정보와 결과를 저장하여 게임의 지속적인 플레이를 도모하고 데이터를 활용할 수 있게 하였습니다.
5. 확률 구현: 난수 생성을 통해 각 공격의 선택과 성공 확률을 구현하여 게임에 다양성과 유연성을 부여하였습니다.

### 시작하기:

저장소를 클론합니다.

bash
Copy code
git clone https://github.com/your-username/RealTimeFightingGame.git
프로젝트를 열고 IDE에서 실행합니다.

게임을 플레이하세요!
