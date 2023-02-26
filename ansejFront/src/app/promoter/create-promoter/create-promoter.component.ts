import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

import { Promoter } from '../../shared/models/promoter';
import { PromoterService } from '../../shared/services/promoter.service';

@Component({
  selector: 'app-create-promoter',
  templateUrl: './create-promoter.component.html',
  styleUrls: ['./create-promoter.component.css']
})
export class CreatePromoterComponent implements OnInit {

	public promoterForm!: FormGroup;
	public promoter!: Promoter;
	public gendertab = ['MALE', 'FEMALE'];
	public typeaddresstab = ['STREET', 'ROAD', 'AVENUE'];
	public educleveltab = ['UNIVERSITY', 'VOCATIONAL TRAINING', 'OTHER'];
	
	constructor(private fb: FormBuilder, private promoterService: PromoterService, private router: Router) {
		this.createForm();
	}
	
	createForm() {
		this.promoterForm = this.fb.group({
		firstname: [null, Validators.required],
		lastname: [null, [Validators.required, Validators.minLength(2)]],
		birthdate: [null, [Validators.required, Validators.minLength(10)]],
		gender: [null, Validators.required],
		father: [null, Validators.required],
		mother: [null, Validators.required],
		birth_cert_num: [null, Validators.required],
		birthcity: [null, Validators.required],
		birthzip: [null, Validators.required],
		birthcountry: [null, Validators.required],
		numaddress: [null, Validators.required],
		typeaddress: [null, Validators.required],
		streetname: [null, Validators.required],
		city: [null, Validators.required],
		zipcode: [null, Validators.required],
		country: [null, Validators.required],
		email: [null, Validators.required],
		phone: [null, Validators.required],
		fax: [null, Validators.required],
		famisitu: [null, Validators.required],
		anemcard: [null, Validators.required],
		educlevel: [null, Validators.required],
		experience: [null, Validators.required],
		degree: [null, Validators.required]
		});
	}

	ngOnInit(): void {
	}
	onSubmit() {
		this.promoter = Object.assign({}, this.promoterForm.value);
		console.log('Saving Promoter:', this.promoter);
		this.promoterService.savePromoter(this.promoter).subscribe((result) => {
		console.log('the result= ', result);
		}, (err) => {
			console.error('Error saving promoter:', err);
		});
		this.router.navigate(['promoters', 'list']);
	}
}
