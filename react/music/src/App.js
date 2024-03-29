import './App.css';
import { useState } from 'react';
import {BrowserRouter, Route, Link, Routes, useLocation, useNavigate} from 'react-router-dom'; 

function App() {

    /*
        음악을 조회하고 등록하는 사이트
        음악 조회는 /에서 
        음악 등록은 /insert에서
        음악 등록시 음악번호(숫자), 제목, 가수, 장르를 입력받음
        음악 번호는 중복되지 않게 입력해서 추가
        음악 조회에서 음악 삭제 버튼을 클릭 => 삭제
        - 음악 번호를 이용하여 삭제
    */
     
    let [list, setList] = useState([{
        num : 1,
        title : "공지사항2",
        singer : "admin",
        genre : "공지사항2입니다."
        },{
        num : 2,
        title : "공지사항",
        singer : "admin",
        genre : "공지사항입니다."
        }
    ]);

    function addSong(song){
        setList([song, ...list]);
    }

    function removeSong(num){
        let tmpList = [...list];
        for(let i = 0; i < tmpList.length; i++){
            if(tmpList[i].num == num){
                tmpList.splice(i,1);
            }
        }
        setList(tmpList);
    }

    return (
        <BrowserRouter>
            <ul className="menu-list">
                <li><Link to="/">메인</Link></li>
                <li><Link to="/insert">음악 추가</Link></li>
            </ul>
            <Routes>
                <Route path="/" exact element={<Home list={list} addSong={addSong} remove={removeSong}/>} />
                <Route path="/insert" element={<Insert />} />
            </Routes>
        </BrowserRouter>
    );
}

function Home({list, addSong, remove}) {

    const location = useLocation();

    let song = location.state;
    if(song != null){
        for(let i = 0; i < list.length; i++){
            if(list[i].num == song.num){
                alert("있는 번호입니다.");
                return;
            }
        }
        addSong(song);
        location.state = null;  // 추가를 했으니 전송된 정보를 비움
    }

    return (
        <table>
            <thead>
                <tr>
                    <th>음악 번호</th>
                    <th>음악 제목</th>
                    <th>음악 가수</th>
                    <th>음악 장르</th>
                </tr>
            </thead>
            <tbody>
                {list.map((item)=>{
                    return (
                        <tr>
                            <th>{item.num}</th>
                            <th>{item.title}</th>
                            <th>{item.singer}</th>
                            <th>{item.genre}</th>
                            <button type='button' onClick={()=>remove(item.num)}>&times;</button>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
};

function Insert() {
    
    let [num, setNum] = useState(0);
    let [title, setTitle] = useState(0);
    let [singer, setSinger] = useState(0);
    let [genre, setGenre] = useState(0);

    // 다른 페이지로 정보를 전송하기 위해서 navigate 사용
    const navigate = useNavigate();

    function insertSong(){
        // 매개변수 : 보낼 url, 상태정보
        navigate("/", {
            state : {
                num, title, singer, genre
            }
        });
    }

    const numChange = (e) => setNum(e.target.value);

    return (
        <div>
            <h1>음악 추가</h1>
            <div>
                <label>번호</label>
                <input type='number' placeholder='번호' onChange={numChange} />
            </div>
            <div>
                <label>제목</label>
                <input type='text' placeholder='제목' onChange={(e)=>setTitle(e.target.value)} />
            </div>
            <div>
                <label>가수</label>
                <input type='text' placeholder='가수' onChange={(e)=>setSinger(e.target.value)} />
            </div>
            <div>
                <label>장르</label>
                <input type='text' placeholder='장르' onChange={(e)=>setGenre(e.target.value)} />
            </div>
            <button type='button' onClick={insertSong}>음악 추가</button>
        </div>
    );
};

export default App;