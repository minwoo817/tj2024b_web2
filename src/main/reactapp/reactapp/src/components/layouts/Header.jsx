
import { Link } from 'react-router-dom'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faHouse } from "@fortawesome/free-solid-svg-icons";
import { faUserPlus } from "@fortawesome/free-solid-svg-icons";
import { faCircleUser } from "@fortawesome/free-solid-svg-icons";

export default function Header( props ){
    return (<> 
        <div>
            <ul>
                <li> <Link to="/"> <FontAwesomeIcon icon={faHouse} className="faCircleUser" />&nbsp; 홈으로 </Link> </li>
                <li> <Link to="/member/signup"> <FontAwesomeIcon icon={faUserPlus} className="faCircleUser" />&nbsp; 회원가입 </Link> </li>
                <li> <Link to="/member/login"> <FontAwesomeIcon icon={faCircleUser} className="faCircleUser" />&nbsp; 로그인 </Link> </li>
            </ul>
        </div>
    </>)
}