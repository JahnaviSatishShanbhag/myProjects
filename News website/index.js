let audio = new Audio('audio/Arijit Singh - Sawan Aaya Hai.mp3');

function currentTime() {
    let dateObj = new Date();
    let curHours = dateObj.getHours();
    let curMinutes = dateObj.getMinutes();
    let curSeconds = dateObj.getSeconds();
    let date = document.querySelector('#myTime');
    if (parseInt(curHours) >= 0 && parseInt(curHours) < 10) {
        curHours = `0${curHours}`;
    }
    if (parseInt(curMinutes) >= 0 && parseInt(curMinutes) < 10) {
        curMinutes = `0${curMinutes}`;
    }
    if (parseInt(curSeconds) >= 0 && parseInt(curSeconds) < 10) {
        curSeconds = `0${curSeconds}`;
    }
    date.innerHTML = `${curHours} : ${curMinutes} : ${curSeconds}`;
}

function makeBoxVisible() {
    let setAlarm = document.querySelector('#setAlarm');
    if (setAlarm.style.visibility == 'hidden') {
        setAlarm.style.visibility = 'visible';
    }
    else {
        setAlarm.style.visibility = 'hidden';
    }
}

function setAlarm() {
    let hours = document.querySelector('#hours');
    let minutes = document.querySelector('#minutes');
    let setHours = hours.value;
    let setMinutes = minutes.value;
    let dateObject = new Date();
    if (parseInt(setHours) == parseInt(dateObject.getHours()) && parseInt(setMinutes) == parseInt(dateObject.getMinutes())) {
        let beforePlay = dateObject.getSeconds();
        while ((dateObject.getSeconds() - beforePlay) != 40) {
            audio.play();
        }
    }
}

window.onload = function () {
    let time = window.setInterval(currentTime, 1000);
    document.querySelector('#set').addEventListener('click', makeBoxVisible);
    document.querySelector('#okay').addEventListener('click', setAlarm);
}
