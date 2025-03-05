/*
    리액트 과제1 : 아래 코드들을 사용하여 결과 예시 구현하여 제출
    조건1 : 두개의 컴포넌트 모두 활용하시오.
    카카오톡 IP 제출
*/


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