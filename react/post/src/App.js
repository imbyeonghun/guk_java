import './App.css';
import { useState } from 'react';
import {BrowserRouter, Route, Link, Routes, useLocation, useNavigate} from 'react-router-dom'; 
// ./ => 현재 폴더  ../ => 상위 폴더  / => 최상위 폴더

function App() {

    let [list, setList] = useState([{
        title : "공지사항2",
        writer : "admin",
        content : "공지사항2입니다."
        },{
        title : "공지사항",
        writer : "admin",
        content : "공지사항입니다."
        }
    ]);

    function addPost(post){
        setList([post, ...list]);
    };

    function deletePost(index){
        let tmpList = [...list];
        tmpList.splice(index,1);
        setList(tmpList);
    };

    return (
        <BrowserRouter>
            <ul className="menu-list">
                <li><Link to="/">메인</Link></li>
                <li><Link to="/post/list">게시글 리스트</Link></li>
                <li><Link to="/post/insert">게시글 작성</Link></li>
            </ul>
            <Routes>
                <Route path="/" exact element={<Home/>} />
                <Route path="/post/list" element={
                    <List list={list} 
                        remove={deletePost} 
                        add={addPost}/>} 
                />
                <Route path="/post/insert" element={<Insert />} />
            </Routes>
        </BrowserRouter>
    )
}


function Home() {
    return <h1>홈</h1>
};

function List({list, add, remove}){

    // 다른 페이지에서 전송한 정보를 받기 위해 location를 이용
    const location = useLocation();

    // 정보를 전송을 하면 location.state에 전송된 정보들이 저장됨
    let post = location.state;
    if(post != null){
        add(post);
        location.state = null;  // 추가를 했으니 전송된 정보를 비움
    }

    return( 
        <table>
            <thead>
                <tr>
                    <th>제목</th>
                    <th>내용</th>
                    <th>작성자</th>
                </tr>
            </thead>
            <tbody>
                {list.map((item,index)=>{
                    return (
                        <tr>
                            <th>{item.title}</th>
                            <th>{item.content}</th>
                            <th>{item.writer}</th>
                            <button type='button' onClick={()=>remove(index)}>&times;</button>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
}

function Insert(){

    let [title, setTitle] = useState("");
    let [writer, setWriter] = useState("");
    let [content, setContent] = useState("");

    // 다른 페이지로 정보를 전송하기 위해서 navigate 사용
    const navigate = useNavigate();

    function insertPost(){
        // 매개변수 : 보낼 url, 상태정보
        navigate("/post/list", {
            state : {
                title, writer, content
            }
        });
    }

    return( 
        <div>
            <input type="text" placeholder="제목" onChange={(e)=>setTitle(e.target.value)}/>
            <br/>
            <input type="text" placeholder="작성자" onChange={(e)=>setWriter(e.target.value)}/>
            <br/>
            <textarea placeholder="내용" onChange={(e)=>setContent(e.target.value)}></textarea>
            <br/>
            <button onClick={insertPost}>게시글 등록</button>
        </div>
    );
}

export default App; // App 컴포넌트 내보내기