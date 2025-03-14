import { Link } from 'react-router-dom';
import React, { useEffect, useState } from 'react';
import axios from 'axios';

export default function BookRead(props) {
    const [book, setBook] = useState([]);
    
    useEffect(() => {
        (async () => {
            await onRead();
        })();
    }, []);

    const onRead = async () => {
        try {
            const response = await axios.get('http://192.168.40.27:8080/day08task/book');
            console.log("불러온 데이터:", response.data);
                setBook(response.data);
        } catch (error) {
            console.error("데이터를 불러오는 중 오류 발생:", error);
            alert("서버에 연결할 수 없습니다. 네트워크 상태를 확인하세요.");
        }
    };

    return (
        <>
            <div>
                <h3> 전체조회 </h3>
                <table>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>책이름</th>
                            <th>작가명</th>
                            <th>책소개</th>
                        </tr>
                    </thead>
                    <tbody>
                        {book.length > 0 ? (
                            book.map((item) => (
                                <tr key={item.bno}>
                                    <td>
                                        <Link to={`/book/view?bno=${item.bno}`}>{item.bno}</Link>
                                    </td>
                                    <td>{item.title}</td>
                                    <td>{item.writer}</td>
                                    <td>{item.commend}</td>
                                </tr>
                            ))
                        ) : (
                            <tr>
                                <td colSpan="4">데이터가 없습니다.</td>
                            </tr>
                        )}
                </tbody>
            </table>
        </div>
    </>);
}
