import { Component, OnInit, Input } from '@angular/core';
import {LoginService} from '../../security/login/login.service';
import {ImageUploadService} from './image-upload.service';

@Component({
  selector: 'pseu-image-upload',
  templateUrl: './image-upload.component.html',
  styleUrls: ['./image-upload.component.scss']
})
export class ImageUploadComponent implements OnInit {


    @Input() isRound = false;
    @Input() image: string;
    carregando = false;

    state: any = {};
    constructor(private imageUploadService: ImageUploadService, private loginService: LoginService) {
        this.handleImageChange = this.handleImageChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleClick = this.handleClick.bind(this);
        this.handleRemove = this.handleRemove.bind(this);
    }


    ngOnInit() {

        this.state = {
            file: null,
            imagePreviewUrl: this.getMiniaturaPerfil()
        };
    }
    handleImageChange(e) {
       this.carregando = true;
        e.preventDefault();
        const reader = new FileReader();
        const file = e.target.files[0];
        let url: String;
        reader.onloadend = () => {
            this.state.file = file;
            this.state.imagePreviewUrl = this.imageUploadService
              .uploadImage(this.loginService.getUser().idConta.toString(), file)
              .subscribe(url => {
                console.log(url.toString());
                this.loginService.atualizaImagem(url.toString());
                this.carregando = false;
              }, error => console.log(error),
                () =>   this.state.imagePreviewUrl = this.getMiniaturaPerfil());
        };
        reader.readAsDataURL(file);

    }
    handleSubmit(e) {
        e.preventDefault();
        // this.state.file is the file/image uploaded
        // in this function you can save the image (this.state.file) on form submit
        // you have to call it yourself
    }
    handleClick() {
        const input = document.createElement('input');
        input.type = 'file';
        input.onchange = this.handleImageChange;
        input.click();
    }
    handleRemove() {
        this.state.file = null;
        this.state.imagePreviewUrl = this.image !== undefined ? this.image : (this.isRound ? './assets/img/placeholder.jpg' : './assets/img/image_placeholder.jpg');
    }

    getMiniaturaPerfil(): string {
    return this.loginService.getMiniaturaPerfil();
    }
}
