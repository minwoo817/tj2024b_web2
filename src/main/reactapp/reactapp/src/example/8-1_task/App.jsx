import {BrowserRouter, Route, Routes} from 'react-router-dom';
/*라우터로 연결할 컴포넌트 가져온다*/
import BookCreate from './BookCreate.jsx';
import BookRead from './BookRead.jsx';
import SideBar from './SideBar.jsx';
import BookView from './BookView.jsx';
import BookUpdate from './BookUpdate.jsx';
import ReviewCreate from './ReviewCreate.jsx';
import ReviewRead from './ReviewRead.jsx';
import Home from './Home.jsx';

// import'./app.css'

// App.jsx : 라우터(가상URL)이용한 라이팅
export default function App(props){
    return(<>
    <BrowserRouter>{/*모든 라우터를 감싼다*/}
        <div id = "wrap">
            <SideBar/>
            <Routes> {/*가상 으로 정의한 URL 감싼다 */}
                <Route exact path="/" element={<Home />} />{}
                <Route exact path="/bookcreate" element={<BookCreate />} />{}
                <Route exact path="/bookread" element={<BookRead />} />{} 
                <Route exact path="/book/view" element={<BookView />} />
                <Route exact path="/bookupdate" element={<BookUpdate />} />
                <Route exact path="/reviewcreate" element={<ReviewCreate />} />{}
                <Route exact path="/reviewread" element={<ReviewRead />} />{} 
 
            </Routes>
        </div>
    </BrowserRouter>
    </>)
}
