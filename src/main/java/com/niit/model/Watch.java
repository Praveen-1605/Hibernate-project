package com.niit.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Watches")
public class Watch
{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int Watchid;
		@Column
		private String Watchname;
		private String Company;
		private Float price;
		private String link;
		
		@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "watch")
		private List<CartItem> cartItems;
		
		public String getLink() {
			return link;
		}
		public void setLink(String link) {
			this.link = link;
		}
		
		public int getWatchid() {
			return Watchid;
		}
		public void setWatchid(int watchid) {
			Watchid = watchid;
		}
		public String getWatchname() {
			return Watchname;
		}
		public void setWatchname(String watchname) {
			Watchname = watchname;
		}
		public String getCompany() {
			return Company;
		}
		public void setCompany(String company) {
			Company = company;
		}
		public Float getPrice() {
			return price;
		}
		public void setPrice(Float price) {
			this.price = price;
		}
		
		
		
	}																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																							
