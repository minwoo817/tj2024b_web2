import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export default function Reviewr(props) {
    const [rno, setRno] = useState('');
    const [bno, setBno] = useState('');
    const [content, setContent] = useState('');
    const [pwd, setPwd] = useState('');
    const navigate = useNavigate();
    
    const handleCreate = async () => {
        const reviewDto = {
            rno : rno,
            bno : bno,
            content : content,
            pwd : pwd
        };

        try {
            const response = await axios.post('http://192.168.40.27:8080/day08task/review', reviewDto);
            if (response.data == true) {
                alert('등록 성공!');
                navigate("/bookread");  
                setBno('');
                setContent('');
                setPwd('');
            } else {
                alert('등록 실패!');
            }
        } catch (error) {
            console.log(error);
        }
    };

    return (
        <>
            <div>
                <h2>등록 페이지</h2>
                <label>
                    책번호:
                    <input type="number" value={bno} onChange={(e) => setBno(e.target.value)}/>
                </label>
                <br />
                <label>
                    리뷰내용:
                    <input type="text" value={content} onChange={(e) => setContent(e.target.value)}/>
                </label>
                <br />
                <label>
                    비밀번호:
                    <input type="text" value={pwd} onChange={(e) => setPwd(e.target.value)}/>
                </label>
                <br />
                <button onClick={handleCreate}>등록</button>
            </div>
        </>
    );
}