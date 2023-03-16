class AsideEvent {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null){
            this.#instance = new AsideEvent();
        }
        return this.#instance;
    }

    addEventShowMenuButton() {
        const menuButton = document.querySelector('.menu-button');
        menuButton.onclick = () => {
            const menuAside = document.querySelector('.menu-aside');
            if(menuAside.classList.contains('hidden-menu')){
                menuAside.classList.remove('hidden-menu');  
                menuButton.textContent = '◀︎';     
            }else {
                menuAside.classList.add('hidden-menu');
                menuButton.textContent = '▶︎';  
            }        
        }
    }

    addEventMainChange() {
        const menuItems = document.querySelectorAll('.menu-items');
        const menuButton = document.querySelector('.menu-button');
        menuItems.forEach((item, index) => {
            item.onclick = () => {
                const mainContainers = document.querySelectorAll('.main-container');
                const menuAside = document.querySelector('.menu-aside');
                mainContainers.forEach(container => {
                    container.classList.add('main-hidden');
                });
                mainContainers[index].classList.remove('main-hidden');
                menuAside.classList.add('hidden-menu');
                menuButton.textContent = '▶︎';  
            }
        });
    }
}