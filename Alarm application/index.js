let audio = new Audio('audio/fantasy-alarm-clock-ringtone.mp3');

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

window.onload = function () {
    let time = window.setInterval(currentTime, 1000);
    document.querySelector('#set').addEventListener('click', makeBoxVisible);
    document.querySelector('#okay').addEventListener('click', () => {
        let beforePlayHours = parseInt(new Date().getHours());
        let beforePlayMinutes = parseInt(new Date().getMinutes());
        let beforePlaySeconds = parseInt(new Date().getSeconds());
        let setHours = parseInt(document.querySelector('#hours').value);
        let setMinutes = parseInt(document.querySelector('#minutes').value);
        let setMilliseconds = (setHours - beforePlayHours) * 3600000 + (setMinutes - beforePlayMinutes) * 60000-beforePlaySeconds*1000;
        window.setTimeout(() => {
            audio.play();
        }, setMilliseconds);
    });
}
