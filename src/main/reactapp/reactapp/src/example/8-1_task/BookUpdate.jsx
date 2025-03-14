import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { useSearchParams } from 'react-router-dom';

export default function Update() {
    
    const [ searchParams ] = useSearchParams();
    const bno = searchParams.get('bno');
    const [title, setTitle] = useState('');
    const [writer, setWriter] = useState('');
    const [commend, setCommend] = useState('');
    const navigate = useNavigate();

    useEffect(() => {
        const fetchBook = async () => {
            try {
                const response = await axios.get(`http://192.168.40.27:8080/day08task/book/view?bno=${bno}`);
                setTitle(response.data.title);
                setWriter(response.data.writer);
                setCommend(response.data.commend);
            } catch (error) {
                console.error("책 정보를 가져오는 데 실패했습니다.", error);
            }
        };
        fetchBook();
    }, [bno]); 

    const handleUpdate = async () => {
        const pwd = prompt("비밀번호를 입력하세요");  
        const bookDto = {
            bno: bno,  
            title: title,
            writer: writer,
            commend: commend,
            pwd: pwd,
        };
        try {
            const response = await axios.get(`http://192.168.40.27:8080/day08task/book/view?bno=${bno}`);
            if (response.data.pwd == pwd) {
                const response = await axios.put(`http://192.168.40.27:8080/day08task/book?bno=${bno}`, bookDto); 
                if (response.data == true) {
                    setTitle('');
                    setWriter('');
                    setCommend('');
                }
                alert('수정 성공!');
                navigate("/bookread");  
            } else {
                alert('비밀번호가 일치하지 않습니다.');
            }
        } catch (error) {
            console.log(error);
            alert('수정 중 오류가 발생했습니다.');
        }
    };

    return (
        <>
            <div>
                <h2>수정 페이지</h2>
                <label>
                    책 이름:
                    <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} />
                </label>
                <br />
                <label>
                    작가:
                    <input type="text" value={writer} onChange={(e) => setWriter(e.target.value)} />
                </label>
                <br />
                <label>
                    책 소개:
                    <input type="text" value={commend} onChange={(e) => setCommend(e.target.value)} />
                </label>
                <br />
                <button onClick={handleUpdate}>수정</button>
            </div>
        </>
    );
}