import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0)
  const [message, setMessage] = useState("리액트를 시작해봅시다!")
  
  const handleCountClick = () => {
    setCount(count + 1)
    if (count === 4) {
      setMessage("앗, 5번 클릭했네 더 해봐")
    }
    if (count === 9) {
      setMessage("10번 클릭! 쫌만 더 해봐")
    }
    if (count === 19) {
      setMessage("20번 클릭! 그만눌러 이자시가!")
    }
  }

  return (
    <div className="app-container">
      <header className="header">
        <h1 className="title">리액트 앱에 오신 것을 환영합니다!</h1>
        <p className="intro-text">{message}</p>
        <div className="logos">
          <a href="https://vite.dev" target="_blank" className="logo-link">
            <img src={viteLogo} className="logo" alt="Vite logo" />
          </a>
          <a href="https://react.dev" target="_blank" className="logo-link">
            <img src={reactLogo} className="logo react-logo" alt="React logo" />
          </a>
        </div>
      </header>
      
      <main className="main-content">
        <div className="card">
          <h2>카운트 버튼을 클릭해보세요!</h2>
          <button onClick={handleCountClick} className="count-button">
            {count === 0 ? 'Start!' : `현재 카운트: ${count}`}
          </button>
          <p className="info-text">클릭 횟수에 따라 멋진 메시지가 나타납니다!</p>
        </div>
        <p className="docs-link">
          Vite와 React 로고를 클릭하면 더 많은 정보를 확인할 수 있습니다. 🚀
        </p>
      </main>
    </div>
  )
}

export default App
