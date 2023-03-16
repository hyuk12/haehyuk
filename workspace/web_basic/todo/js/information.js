class InformationEvent {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null){
            this.#instance = new InformationEvent();
        }
        return this.#instance;
    }

    addEventPhotoChangeClick() {
        const infoPhoto = document.querySelector('.info-photo');
        infoPhoto.onclick = () => {
            const photoFile = document.querySelector('.photo-file');
            photoFile.click();
        }
    }

    addEventPhotoChange() {
        const photoFile = document.querySelector('.photo-file');
        photoFile.onchange = () => {
            fileService.getInstance().changePhoto();
        }
    }
    
    addEventInformationEdit() {
        this.addEventAboutMeModifyClick();
        this.addEventAboutMeSaveClick();
    }
    
    addEventIntrodutionEdit() {
        this.addEventSelfIntroductionModifyClick();
        this.addEventSelfIntroductionSaveClick();
    }
    
    addEventAboutMeModifyClick() {
        const aboutMeModifyButton = document.querySelector('.m-aboutme');
        aboutMeModifyButton.onclick = () => {
            const aboutMeSaveButton = document.querySelector('.s-aboutme');
            aboutMeSaveButton.classList.remove('button-hidden');
            aboutMeModifyButton.classList.add('button-hidden');
            
            const infoInputContainers = document.querySelectorAll('.info-input-container');
            infoInputContainers.forEach(infoInputContainer => {
                const infoInput = infoInputContainer.querySelector('.info-input');
                infoInput.disabled = false;
            });
            
        }
    }
    
    addEventAboutMeSaveClick() {
        const aboutMeSaveButton = document.querySelector('.s-aboutme');
        aboutMeSaveButton.onclick = () => {
            const aboutMeModifyButton = document.querySelector('.m-aboutme');
            aboutMeModifyButton.classList.remove('button-hidden');
            aboutMeSaveButton.classList.add('button-hidden');
            
            const infoInputContainers = document.querySelectorAll('.info-input-container');
            infoInputContainers.forEach(infoInputContainer => {
                const infoInput = infoInputContainer.querySelector('.info-input');
                infoInput.disabled = true;
            });
        }
    }
    

    addEventSelfIntroductionModifyClick() {
        const selfIntroductionModifyButton = document.querySelector('.m-introduce');
        selfIntroductionModifyButton.onclick = () => {
            const selfIntroductionSaveButton = document.querySelector('.s-introduce');
            selfIntroductionSaveButton.classList.remove('button-hidden');
            selfIntroductionModifyButton.classList.add('button-hidden');
            
            const introduceInput = document.querySelector('.introduce-input');
            introduceInput.disabled = false;
            
        }
    }
    
    addEventSelfIntroductionSaveClick() {
        const selfIntroductionSaveButton = document.querySelector('.s-introduce');
        selfIntroductionSaveButton.onclick = () => {
            const selfIntroductionModifyButton = document.querySelector('.m-introduce');
            selfIntroductionModifyButton.classList.remove('button-hidden');
            selfIntroductionSaveButton.classList.add('button-hidden');
            
            const introduceInput = document.querySelector('.introduce-input');
            introduceInput.disabled = true;
        }
    }

}




class fileService {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null){
            this.#instance = new fileService();
        }
        return this.#instance;
    }

    changePhoto() {
        const photoForm = document.querySelector('.photo-form');
        const formData = new FormData(photoForm);
        const fileValue = formData.get('file');
        this.showPreview(fileValue);
    }

    showPreview(fileValue) {
        const fileReader = new FileReader();
        
        fileReader.readAsDataURL(fileValue);

        fileReader.onload = (e) => {
            const photoImg = document.querySelector('.info-photo img');
            photoImg.src = e.target.result;
        }
    }
}

