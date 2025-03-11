
import {BrowserRouter , Route, Routes} from 'react-router-dom'; // npm i react-router-dom 설치 필요

/* 라우터로 연결할 컴포넌트 import 가져온다. */ 
import Home from './Home';
import Create from './Create';
import Read from './Read';
import Update from './Update';
import Delete from './Delete';
import SideBar from './SideBar';
/* css import */
import './app.css' // ./ : 현재 파일과 같은 경로 뜻

// App.jsx : 라우터(가상URL) 이용한 라이팅
export default function App(props){ // 컴포넌트
    return (<>
        <BrowserRouter>{/* 모든 라우터를 감싼다. */}
            <div id='wrap'>
                <SideBar />
                <Routes> {/* 가상으로 정의한 URL을 감싼다 */}
                    <Route path='/' element={<Home />}/> {/* 각 가상의 URL 정의한다. 컴포넌트 연결 */}
                    <Route path='/create' element={<Create />}/> {/* 각 가상의 URL 정의한다. 컴포넌트 연결 */}
                    <Route path='/read' element={<Read />}/> {/* 각 가상의 URL 정의한다. 컴포넌트 연결 */}
                    <Route path='/update' element={<Update />}/> {/* 각 가상의 URL 정의한다. 컴포넌트 연결 */}
                    <Route path='/delete' element={<Delete />}/> {/* 각 가상의 URL 정의한다. 컴포넌트 연결 */}
                </Routes>
            </div>
        </BrowserRouter>
    </>)
}
