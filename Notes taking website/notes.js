showNotes();
let btn = document.getElementById('addBtn');
btn.addEventListener('click', function () {
    let notes = localStorage.getItem('notes');
    let txt = document.getElementById('addTxt');
    let notesObj;
    if (notes == null) {
        notesObj = [];
    }
    else {
        notesObj = JSON.parse(notes);
    }
    notesObj.push(txt.value);
    localStorage.setItem('notes', JSON.stringify(notesObj));
    txt.value = "";
    showNotes();
});
function showNotes() {
    let notes = localStorage.getItem('notes');
    let notesObj;
    if (notes == null) {
        notesObj = [];
    }
    else {
        notesObj = JSON.parse(notes);
    }
    let html = "";
    notesObj.forEach(function (element, index) {
        html += `
        <div class="noteCard my-2 mx-2 card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">Note ${index + 1}</h5>
                <p class="card-text">${element}</p>
                <button id="${index}" onclick="deleteNote(this.id)" class="btn btn-primary">Delete notes</button>
            </div>
        </div>
        `
    });
    let noteElems = document.getElementById('notes');
    if (notesObj.length != 0) {
        noteElems.innerHTML = html;
    }
    else {
        noteElems.innerHTML = `Nothing to show! Use "Add a Note" section above to add notes.`;
    }
}
function deleteNote(index) {
    let notes = localStorage.getItem('notes');
    let notesObj;
    if (notes == null) {
        notesObj = [];
    }
    else {
        notesObj = JSON.parse(notes);
    }
    notesObj.splice(index, 1);
    localStorage.setItem('notes', JSON.stringify(notesObj));
    showNotes();
}
let search = document.getElementById('searchNotes');
search.addEventListener('input', function () {
    let searchtxt = search.value.toLowerCase();
    // console.log(searchtxt);
    let noteCards=document.getElementsByClassName('noteCard');
    Array.from(noteCards).forEach(function(element)
    {
        let txt=element.getElementsByTagName('p')[0].innerText.toLowerCase();
        if (txt.includes(searchtxt))
        {
            element.style.display='block';
        }
        else
        {
            element.style.display='none';
        }
    });
});
