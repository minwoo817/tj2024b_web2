/*
    리액트 + Spring 과제4 : 리액트 전화번호부 만들기(과제3) +Spring 서버 + myBatis
    조건1 : (저장) 이름 이랑 전화번호 입력받아 Spring 서버에게 전송
    조건2 : (전체출력) 서버로부터 받은 모든 정보(이름 , 전화번호) 를 로 모두 출력
    조건3 : useState 사용 , useEffect 사용 , axios 사용

    폴더 
    리액트는 example 폴더 -> 6_axios 폴더 -> task.jsx
    스프링은 example 폴더 -> day07Task 폴더
*/
import {useEffect, useState} from "react"
import axios from 'axios';
export default function Task(props){
    const [formData, setFormData] = useState({name: '', phone: ''})
    const formDataChange = (e) => {
        setFormData({...formData, [e.target.name]: e.target.value})
    }
    const onPost = async (e) => {
        try{
            const response = await axios.post('http://192.168.40.27:8080/day07task/react', formData)
            if(response.data == true){
                alert('등록 성공');
                setFormData({name: '', phone: ''})
                onFindAll();
            }else{alert('등록 실패');}
        }catch(error){console.log(error);}
    }

    useEffect(() => {onFindAll()}, []);
    const [boards, setBoards] = useState([]);
    const onFindAll = async () => {
        try{
            const response = await axios.get('http://192.168.40.27:8080/day07task/react')
            setBoards(response.data);
        }catch(error){console.log(error);}
    }
    return (<>
    <h4>입력 폼</h4>
    <form>
    이름 : <input type="text" value={formData.name} name="name" onChange={formDataChange}/> <br />
    전화번호 : <input type="text" value={formData.phone} name="phone" onChange={formDataChange}/> <br />
    <button type="button" onClick={onPost}>등록</button>
    </form>
    <table>
        <thead> <tr><th>번호</th><th>이름</th><th>전화번호</th></tr> </thead>
        <tbody>
            {
                boards.map((board, index) => {
                    return (
                    <tr key={index}>
                        <td>{index+1}</td>
                        <td>{board.name}</td>
                        <td>{board.phone}</td>
                    </tr>
                    )
                })
            }
        </tbody>
    </table>
    </>)
}