/*
    리액트 과제3 : 리액트 전화번호부 만들기
    조건1 : (저장) '이름'이랑 '전화번호'입력받아 배열에 저장
    조건2 : (전체출력) 저장된 배열내 모든 정보(이름/전화번호)를 table 또는 ol 또는 ul로 모두 출력하시오.
    조건3 : useState 사용
*/

import { useState } from "react";

export default function Task2() {
    const [name, setName] = useState('')
    const [phone, setPhone] = useState('')
    const [infos, setInfo] = useState([])

    const save = (e) => {
        const info = {
            name : name,
            phone : phone
        }
        setInfo([...infos, info])
    }

    const handleChange1 = (event) => {
        setName(event.target.value);
    }

    const handleChange2 = (event) => {
        setPhone(event.target.value);
    }

    return (<>
        <div>
            <h2>이름 입력하기</h2>
            <input value = {name} onChange={handleChange1} />
            <h2>전화번호 입력하기</h2>
            <input value={phone} onChange={handleChange2} /> <br />
            <button onClick={save}>저장</button>
        </div>
        <div>
            <h2>전체출력</h2>
            <ul>
          {infos.map((info, index) => (
            <li key={index}>{info.name} : {info.phone}</li>
          ))}
        </ul>
        </div>
    </>)
}