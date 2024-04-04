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
        title : "Movie1",
        genre : "Drama",
        releaseDate : "2022-01-01"
        },{
        num : 2,
        title : "Movie2",
        genre : "Action",
        releaseDate : "2022-02-01"
        },{
        num : 3,
        title : "Movie3",
        genre : "Comedy",
        releaseDate : "2022-03-01"
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
                <li><Link to="/">List</Link></li>
                <li><Link to="/insert">Add New Music</Link></li>
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
        <div className='ListBox'>
            <h1>Movies</h1>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Genre</th>
                        <th>Release Date</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {list.map((item)=>{
                        return (
                            <tr>
                                <th>{item.num}</th>
                                <th>{item.title}</th>
                                <th>{item.genre}</th>
                                <th>{item.releaseDate}</th>
                                <button type='button' onClick={()=>remove(item.num)}>Delete</button>
                            </tr>
                        );
                    })}
                </tbody>
            </table>
        </div>
    );
};

function Insert() {
    
    let [num, setNum] = useState(0);
    let [title, setTitle] = useState(0);
    let [genre, setGenre] = useState(0);
    let [releaseDate, setReleaseDate] = useState(0);

    // 다른 페이지로 정보를 전송하기 위해서 navigate 사용
    const navigate = useNavigate();

    function insertSong(){
        // 매개변수 : 보낼 url, 상태정보
        navigate("/", {
            state : {
                num, title, genre, releaseDate
            }
        });
    }

    const numChange = (e) => setNum(e.target.value);

    return (
        <div>
            <h1>Create Movie</h1>
            <div>
                <input type='number' placeholder='Input movie id' onChange={numChange} />
            </div>
            <div>
                <input type='text' placeholder='Input movie title' onChange={(e)=>setTitle(e.target.value)} />
            </div>
            <div>
                <input type='text' placeholder='Input movie genre' onChange={(e)=>setGenre(e.target.value)} />
            </div>
            <div>
                <label>출시일 : </label>
                <input type='date' placeholder='장르' onChange={(e)=>setReleaseDate(e.target.value)} />
            </div>
            <button type='button' onClick={insertSong}>Add Movie</button>
        </div>
    );
};

export default App;