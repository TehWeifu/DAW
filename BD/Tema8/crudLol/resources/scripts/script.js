const editBtn = document.querySelector(".js_editBtn")
const deleteBtn = document.querySelector(".js_deleteBtn")

deleteBtn.addEventListener("click", () => {
    let idsToDelete = [];

    document.querySelectorAll(".chkBox").forEach(item => {
        if (item.checked) idsToDelete.push(item.value)
    })

    if (idsToDelete.length === 0) {
        window.alert("No se ha seleccionado ningún registro para eliminar.")
        return
    }
    if (!printPopUpMsg(idsToDelete.length)) return

    let currentUrl = location.protocol + '//' + location.host + location.pathname;
    let newUrl = currentUrl + "?del"

    for (const id of idsToDelete) {
        newUrl += `&delArr[]=${id}`
    }
    window.location.href = newUrl
})


editBtn.addEventListener("click", () => {
    let idToEdit;
    try {
        idToEdit = document.querySelector(".chkBox:checked").value;
    } catch (e) {
        window.alert("No se ha seleccionado ningún registro para editar.")
        return
    }

    let currentUrl = location.protocol + '//' + location.host + location.pathname;

    window.location.href = currentUrl + `?edit&idx=${idToEdit}`
})

function printPopUpMsg(numOfElementsToDelete) {
    return window.confirm(`Esta seguro que desea eliminar ${numOfElementsToDelete} registro(s)?`)
}
