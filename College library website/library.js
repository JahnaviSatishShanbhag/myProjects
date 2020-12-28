class Book {
    constructor(name, author, type) {
        this.name = name;
        this.author = author;
        this.type = type;
    }
}
class Display {
    add(book) {
        let html = "";
        let bookDetails = document.getElementById('bookDetails');
        html = `<tr>
                <td scope="col">${book.name}</td>
                <td scope="col">${book.author}</td>
                <td scope="col">${book.type}</td>
              </tr>`;
        bookDetails.innerHTML += html;
    }
    clear() {
        let btn = document.getElementById('btn');
        btn.type='reset';
    }
}
let btn = document.getElementById('btn');
btn.addEventListener('click', () => {
    let bookName = document.getElementById('bookName').value;
    let author = document.getElementById('author').value;
    let type = "";
    if (document.getElementById('cricket').checked) {
        type = document.getElementById('cricket').value;
    }
    else if (document.getElementById('programming').checked) {
        type = document.getElementById('programming').value;
    }
    else {
        type = document.getElementById('cooking').value;
    }
    let myNewBook = new Book(bookName, author, type);
    let bookDisplay = new Display();
    bookDisplay.add(myNewBook);
    bookDisplay.clear();
});

