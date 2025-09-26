nav
{
    position: fixed;
    background: #8E54E9;
    color: white;
    top: 0;
    left: 0;
    width: 100%;
    padding: 20px;
    transition: all 0.4s ease;
    z-index: 10;
}
nav .nav-content
{
    height: 100%;
    max-width: 1400px;
    margin: auto;
    display: flex;
    align-items: center;
    justify-content: space-between;
}
nav .logo a{
    font-weight: 500;
    font-size: 35px;
    color: white;
    text-decoration: none;
    /* color: #8E54E9; */
}
.nav-content .nav-links{
    display: flex;
}
.nav-content .nav-links li{
    list-style: none;
    margin: 0 8px;
}
.nav-links li a
{
    text-decoration: none;
    color: white;
    font-size: 18px;
    font-weight: 500;
    padding: 10px 4px;
    transition: all 0.3s ease;
}
.nav-links li a:hover
{
    text-decoration: underline;
}

.content{
    margin-top: 90px;
}