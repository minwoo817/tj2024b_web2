

// (1) function : 함수 선언 키워드
// (2) 컴포넌트명 정의한다.(첫글자 대문자로 필수)
// (3) (props){} : 매개변수는 props 필수로 한다. (생략가능)
// (4) {return jsx문법} : JSX 문법 작성
// (5) 여러 컴포넌트 중에서 import 할 경우 반환할 컴포넌트 정의한다.
function Component2(props){
    return <div><Header />메인페이지<Footer /></div>
}

export default Component2;

// [2] 그 외 컴포넌트
    // (1) 헤더 컴포넌트
function Header(props){
    return <div>헤더 메뉴</div>
}
    // (2) 푸터 컴포넌트
function Footer(props){
    return <div>푸터 메뉴</div>
}