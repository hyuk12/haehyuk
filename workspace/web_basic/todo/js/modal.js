class ModalEvent {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null){
            this.#instance = new ModalEvent();
        }
        return this.#instance;
    }

    addEventCancelClick() {
        const modalCancleButton = document.querySelector('.modal-cancel-button');
        modalCancleButton.onclick = () => {
            ModalService.getInstance().closeModal();
        }
    }

    addEventRemoveOkClick(removeIndex) {
        const modalOkButton = document.querySelector('.modal-ok-button');
        modalOkButton.onclick = () => {
            TodoService.getInstance().todoList.splice(removeIndex, 1);
            TodoService.getInstance().updateLocalStorage();
            ModalService.getInstance().closeModal();
        }
    }

    addEventModifyOkClick(modifyIndex) {
        const modalOkButton = document.querySelector('.modal-ok-button'); 
        modalOkButton.onclick = () => {
            const modalModifyContent = document.querySelector('.modal-modify-content');
            TodoService.getInstance().todoList[modifyIndex].todoContent = modalModifyContent.value;
            TodoService.getInstance().updateLocalStorage();
            ModalService.getInstance().closeModal();
        }
    }


}

class ModalService {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null){
            this.#instance = new ModalService();
        }
        return this.#instance;
    }

    showModal() {
        const modalContainer = document.querySelector('.modal-container');
        modalContainer.classList.remove('modal-hidden');
    }
    
    closeModal() {
        const modalContainer = document.querySelector('.modal-container');
        modalContainer.classList.add('modal-hidden');
    }

    showRemoveModal(removeIndex) {
        const modalSection = document.querySelector('.modal-section');
        modalSection.innerHTML = `
        <div class="modal-header">
            <h1 class="modal-title">ToDo 삭제</h1>
        </div>
        <div class="modal-main">
            <p class="modal-message">ToDo를 삭제하시겠습니까?</p>
        </div>
        <div class="modal-footer">
            <button type="button" class="modal-ok-button">확인</button>
            <button type="button" class="modal-cancel-button">취소</button>
        </div>
        
        `;
        ModalEvent.getInstance().addEventRemoveOkClick(removeIndex);
        ModalEvent.getInstance().addEventCancelClick();
        this.showModal();
    }

    showModifyModal(modifyIndex) {
        const modalSection = document.querySelector('.modal-section');
        
        const todoObj = TodoService.getInstance().todoList[modifyIndex];
            modalSection.innerHTML = `
                <div class="modal-header">
                    <h1 class="modal-title">ToDo 수정</h1>
                </div>
                <div class="modal-main">
                    <p class="modal-message">${todoObj.todoDate}.${todoObj.todoDateTime}</p>
                    <input type="text" class="modal-modify-content" value=''>
                </div>
                <div class="modal-footer">
                    <button type="button" class="modal-ok-button">확인</button>
                    <button type="button" class="modal-cancel-button">취소</button>
                </div>
            `;
      
        ModalEvent.getInstance().addEventModifyOkClick(modifyIndex);
        ModalEvent.getInstance().addEventCancelClick();
        TodoEvent.getInstance().addEventModifyTodoKeyUp();
        this.showModal();
    }
}