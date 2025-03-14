import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export default function BookCreate(props) {
    const [bname, setBname] = useState('');
    const [bwriter, setBwriter] = useState('');
    const [bcommend, setBcommend] = useState('');
    const [bpwd, setBpwd] = useState('');
    const navigate = useNavigate();

    const handleCreate = async () => {
        // 입력값이 비어 있는지 체크
        if (!bname || !bwriter || !bcommend || !bpwd) {
            alert("모든 입력 필드를 채워주세요!");
            return;
        }

        const bookDto = {
            title: bname,
            writer: bwriter,
            commend: bcommend,
            pwd: bpwd
        };

        // 전송할 데이터 확인
        console.log("보낼 데이터:", bookDto);

        try {
            // 서버에 데이터 전송
            const response = await axios.post('http://192.168.40.27:8080/day08task/book', bookDto);

            // 서버 응답 확인
            console.log("서버 응답:", response.data);
            if (response.data === true) {
                alert('등록 성공!');
                navigate("/bookread");  // 성공 시, 책 목록 페이지로 이동
                // 입력값 초기화
                setBname('');
                setBwriter('');
                setBcommend('');
                setBpwd('');
            } else {
                alert('등록 실패!');
            }
        } catch (error) {
            // 에러 발생 시 처리
            console.error("에러 발생:", error);
            alert('서버와의 연결에 문제가 발생했습니다.');
        }
    };

    return (
        <div>
            <h2>등록</h2>
            <label>
                제목:
                <input type="text" value={bname} onChange={(e) => setBname(e.target.value)} />
            </label>
            <br />
            <label>
                작가:
                <input type="text" value={bwriter} onChange={(e) => setBwriter(e.target.value)} />
            </label>
            <br />
            <label>
                소개:
                <input type="text" value={bcommend} onChange={(e) => setBcommend(e.target.value)} />
            </label>
            <br />
            <label>
                비밀번호:
                <input type="password" value={bpwd} onChange={(e) => setBpwd(e.target.value)} />
            </label>
            <br />
            <button onClick={handleCreate}>등록</button>
        </div>
    );
}
