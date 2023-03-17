window.onload = () => {
    AsideEvent.getInstance().addEventShowMenuButton();
    AsideEvent.getInstance().addEventMainChange();
    InformationService.getInstance().loadInfo();
    InformationEvent.getInstance().addEventPhotoChangeClick();
    InformationEvent.getInstance().addEventPhotoChange();
    InformationEvent.getInstance().addEventInformationEdit();
    InformationEvent.getInstance().addEventIntrodutionEdit(); 
    TodoEvent.getInstance().addEventAddTodoClick();
    TodoEvent.getInstance().addEventAddTodoKeyUp();
    
    TodoService.getInstance();
    
    // InformationEvent.getInstance().addEventAboutMeModifyClick();
    // InformationEvent.getInstance().addEventAboutMeSaveClick();

}