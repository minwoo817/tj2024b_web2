import { Link } from "react-router-dom"
export default function SideBar(props) {
    return(<>
        <ul>
            <li>사이드바 메뉴</li>
            <li><Link to="/bookcreate">책 등록 </Link></li>
            <li><Link to="/bookread">책 출력</Link></li>
            <li><Link to="/reviewcreate">리뷰 등록</Link></li>
            <li><Link to="/reviewread">리뷰 조회</Link></li>
        </ul>
    </>)
}