import React from 'react'
import Sidebar from './Sidebar'
import Header from './Header'
import MainContent from './MainContent'

const Dashboard = () => {
  return (
    <div className='dashboard-main-wrapper'>
        <Header />
        <Sidebar />
        <MainContent />
    </div>
  )
}

export default Dashboard