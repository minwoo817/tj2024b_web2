const onSave = () => {
const title = document.querySelector('.title').value;
const content = document.querySelector('.content').value;
const obj = { title, content };
axios.post('/day04/task/board', obj)
    .then(response => {console.log(response.data); onFindAll();})
    .catch(error => console.error(error));
}
const onFindAll = async () => {
    try {
        const r = await axios.get('/day04/task/board');
        const tbody = document.querySelector('tbody');
        let html = '';
        r.data.forEach(board => {
            html += `<tr>
                        <td><a href="board.html?bno=${ board.bno }">${board.title}</a></td>
                        <td>${board.content}</td>
                        <td>
                            <button onclick="onUpdate(${board.bno})">수정</button>
                            <button onclick="onDelete(${board.bno})">삭제</button>

                        </td>
                    </tr>`;
        });
        tbody.innerHTML = html;
    } catch (e) {
        console.log(e);
    }
}
onFindAll();


// board.html에 들어갔을 때 실행할 코드
window.onload = async function () {
    // URL에서 bno 파라미터 추출
    const urlParams = new URLSearchParams(window.location.search);
    const bno = urlParams.get('bno');  // URL에서 bno 값을 가져옴

    // 해당 bno에 맞는 게시글을 조회하는 API 호출
    if (bno) {
        try {
            const response = await axios.get(`/day04/task/board/view?bno=${bno}`);
            console.log(response.data); // 서버에서 받은 데이터 확인

            // 게시글 제목과 내용을 화면에 표시
            document.querySelector('.onetitle').value = response.data.title;
            document.querySelector('.onecontent').value = response.data.content;
        } catch (error) {
            console.error("게시글 조회 실패:", error);
        }
    } else {
        console.log("bno 값이 없습니다.");
    }
}



const onUpdate = async(bno) => {
    const title = prompt('새로운 제목')
    const content = prompt('새로운 내용')

    const obj = {bno, title, content}

    const r = await axios.put('/day04/task/board', obj)
    if(r.data == 1) {onFindAll();}
}

const onDelete = async(bno) => {
    const r = await axios.delete(`/day04/task/board?bno=${bno}`)
    if(r.data == 1) {onFindAll();}
}