# DevKor SSO
DevKor의 Single Sign On을 구축하기 위한 프로젝트입니다.

# Git Convention
1. feature 추가시 issue를 먼저 등록하고 작업
2. branch명 규칙
   * branch명의 prefix는 다음 중 하나를 선택
     * Feature : 기능을 개발하는 브랜치
     * Hotfix : 출시 버전에서 발생한 버그를 수정하는 브랜치
   * {prefix}/{issue번호}-{작업 이름}
3. main에 직접 commit하는 경우는 지양
4. commit명의 prefix는 다음 중 하나를 선택
   * "feat" : 새로운 기능 추가
   * "docs" : 문서 수정
   * "refactor" : 코드 리펙토링
   * "chore" : 빌드 작업, 패키지 관리자 구성 등 업데이트, Production Code 변경 없음
   * "test" : 테스트 코드 작성