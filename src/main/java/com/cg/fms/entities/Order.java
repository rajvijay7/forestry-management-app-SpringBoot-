package com.cg.fms.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                                      
@NoArgsConstructor                        
@Entity                                   
@Table(name = "Order_tbl")             
public class Order {
	
	@Id                                
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")   
	private Integer id;                  
	
	
	@Column(name = "totalprice")         //FROM CART
	@NotNull
	private String totalprice;
	
	
	@Column(name = "quantity")           //FROM CART
	@NotNull
	private String quantity;
	
	
	@Column(name = "name")              //CUSTOMER NAME FROM CUSTOMER TABLE
	@NotNull
	private String name;
	
	
	@Column(name = "email")             //CUSTOMER EMAIL FROM CUSTOMER TABLE
	private String email;
	
	
	@Column(name = "address")           //CUSTOMER ADDRESS FROM CUSTOMER TABLE
	@NotNull
	private String address;
	
	
	@Column(name = "town")              //CUSTOMER TOWN FROM CUSTOMER TABLE
	private String town; 
	
	
	@Column(name = "postal_code")       //CUSTOMER POSTAL CODE FROM CUSTOMER TABLE
	@NotNull
	private long postalcode;
	
	
	@Column(name = "contact")          //CUSTOMER CONTACT CODE FROM CUSTOMER TABLE
	private long contact;
	
	
	@Column(name = "deliverydate")
	@NotNull
	private String deliverydate;
	
	
	
	
	
	
	
	
	
//	@OneToMany(targetEntity = Contract.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "occ_fk", referencedColumnName = "id")
//	private List<Contract> contracts;
//	
//	@OneToMany(targetEntity = Scheduler.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "cc_fk", referencedColumnName = "id")
//	private List<Scheduler> schedulers;
//	
//	@OneToMany(targetEntity = Customer.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "oc_fk", referencedColumnName = "id")
//	private List<Customer> customers;

	
}