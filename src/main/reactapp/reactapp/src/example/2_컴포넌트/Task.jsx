/*
    리액트 과제1 : 아래 코드들을 사용하여 결과 예시 구현하여 제출
    조건1 : 두개의 컴포넌트 모두 활용하시오.
    카카오톡 IP 제출
*/

// 컴포넌트란? 1. 클래스형 컴포넌트 = 클래스타입 2. 함수형 컴포넌트(*)
// ProductCard 컴포넌트 : 하나의 제품정보를 표현하는 UI 구역 (하위)
// Task 컴포넌트 : 여러개의 ProductCard 컴포넌트 포함하는 UI 구역 (상위)
// 1. 샘플 데이터로 간단한 화면 구현
// 2. 
// 3. props : 하위 컴포넌트의 속성(매개변수) 전달
// 4. 반복문 이용한 하위 컴포넌트 호출
import './Task.css'
const ProductCard = (props) => {
    const product = props.children;
    return (<div className="product">
        <h2>{product.title}</h2>
        <h5>가격 : {product.price}</h5>
        <h5 style={{color : product.inStock==true ? 'green' : 'red'}}>{product.inStock==true ? "재고 있음" : "재고 없음"}</h5>
    </div>);
}

export default function Task( props ) {
  
    const products = [
      { title: "무선 키보드", price: 45000, inStock: true },
      { title: "게이밍 마우스", price: 32000, inStock: false },
      { title: "27인치 모니터", price: 280000, inStock: true }
    ];
    return (<div className="task">
        {products.map((product, index) => (
            <ProductCard key = {index}>{product}</ProductCard>
        ))}
    </div>);    
  }