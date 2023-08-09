import React, { useState } from 'react'
import Sidebar from './Sidebar'
import Header from './Header'
import MainContent from './MainContent'

const Dashboard = () => {
  const [textDB, setTextDB] = useState("Security");
  return (
    <div className='dashboard-main-wrapper'>
        <Header />
        <Sidebar setTextDB = {setTextDB} />
        <MainContent textDB = {textDB} />
    </div>
  )
}

export default Dashboard