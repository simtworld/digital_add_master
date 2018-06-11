SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";
DROP DATABASE DigitalAdd;
CREATE DATABASE DigitalAdd;
use DigitalAdd;

--
-- Table structure for table `user roles`
--

CREATE TABLE IF NOT EXISTS `user_roles` (
  `id` int(11) NOT NULL,
  `roles` varchar(100) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `countries`
--

CREATE TABLE IF NOT EXISTS `countries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sortname` varchar(3) NOT NULL,
  `name` varchar(150) NOT NULL,
  `phonecode` int(11) NOT NULL,
 `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4121 ;



--
-- Table structure for table `states`
--
CREATE TABLE IF NOT EXISTS `states` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `country_id`  int(11) NOT NULL ,
  `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  CONSTRAINT fk_country_id FOREIGN KEY (country_id) REFERENCES countries(id)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4121 ;


--
-- Table structure for table `cities`
--

CREATE TABLE IF NOT EXISTS `cities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `state_id` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  CONSTRAINT fk_states_id FOREIGN KEY (state_id) REFERENCES states(id)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=47577 ;



--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `uuid` int(10)  NOT NULL,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(255)  NOT NULL,
  `user_type_id`  int(11) NOT NULL,
   `mobile_verfication_status`  int(1) NOT NULL DEFAULT '0',
    `email_verfication_status`  int(1) NOT NULL DEFAULT '0',
	`country_id`  int(11) NOT NULL ,
	`state_id`  int(11) NOT NULL,
	`city_id`  int(11) NOT NULL ,
  `password` varchar(255)  NOT NULL,
  `wallet_balance` varchar(255) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
   PRIMARY KEY (`uuid`),
  CONSTRAINT fk_user_user_type_id FOREIGN KEY (user_type_id) REFERENCES user_roles(id),
   CONSTRAINT fk_user_country_id FOREIGN KEY (country_id) REFERENCES countries(id),
    CONSTRAINT fk_user_state_id FOREIGN KEY (state_id) REFERENCES states(id),
	 CONSTRAINT fk_user_city_id FOREIGN KEY (city_id) REFERENCES cities(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Table structure for table `otp`
--

CREATE TABLE IF NOT EXISTS `otp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `otp_uuid` int(10)  NOT NULL,
  `otp` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT fk_otp_uuid FOREIGN KEY (otp_uuid) REFERENCES user(uuid)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;


--
-- Table structure for table `plans`
--

CREATE TABLE `plans` (
  `plan_id` int(10)  NOT NULL,
  `plan_name` varchar(255)  NOT NULL,
  `plan_price` varchar(255) NOT NULL,
  `per_click_price` varchar(255) NOT NULL,
  `no_of_clicks_per_day` int(11) NOT NULL,
  `plan_validity_period` int(11) NOT NULL,
  `plan_description` varchar(1000) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
   PRIMARY KEY (`plan_id`)
)  ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;

--
-- Table structure for table `user_plan_status`
--

CREATE TABLE `user_plan_status` (
  `plan_status_id` int(10) NOT NULL,
  `plan_status` int(10) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
   PRIMARY KEY (`plan_status_id`)
)  ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;

--
-- Table structure for table `user_plans`
--

CREATE TABLE `user_plans` (
  `user_plan_id` int(10) NOT NULL,
  `plan_id` int(10) NOT NULL,
  `uuid` int(10) NOT NULL,
  `plan_status_id` int(10) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
   PRIMARY KEY (`user_plan_id`),
   CONSTRAINT fk_user_plan_id FOREIGN KEY (plan_id) REFERENCES plans(plan_id),
   CONSTRAINT fk_user_uuid FOREIGN KEY (uuid) REFERENCES user(uuid),
   CONSTRAINT fk_user_plan_status FOREIGN KEY (plan_status_id) REFERENCES user_plan_status(plan_status_id)
)  ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;


--
-- Table structure for table `user_plans_daily_status`

-- automatically records creation based on condition

CREATE TABLE `user_plans_daily_status` (
  `upd_status_id` int(10) NOT NULL,
  `user_plan_id` int(10) NOT NULL,
  `hits` int(10) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
   PRIMARY KEY (`upd_status_id`),
   CONSTRAINT fk_upds_user_plan_id FOREIGN KEY (user_plan_id) REFERENCES user_plans(user_plan_id)
)  ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;

--
-- Table structure for table `products`
-- 

CREATE TABLE `products` (
  `product_id` int(10) NOT NULL,
  `product_name` varchar(1000) NOT NULL,
  `product_url` varchar(2000) NOT NULL,
  `product_description_sms` varchar(1000) NULL,
  `product_description_email` varchar(5000) NULL,
  `product_image_extension` varchar(20) NOT NULL,  
  `product_country_id`  int(11) NOT NULL ,
  `product_state_id`  int(11) NOT NULL,
  `product_city_id`  int(11) NOT NULL ,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
   PRIMARY KEY (`product_id`),
   CONSTRAINT fk_product_country_id FOREIGN KEY (product_country_id) REFERENCES countries(id),
    CONSTRAINT fk_product_state_id FOREIGN KEY (product_state_id) REFERENCES states(id),
	 CONSTRAINT fk_product_city_id FOREIGN KEY (product_city_id) REFERENCES cities(id)
)  ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;


--
-- Table structure for table `mobile_receivers`
-- 

CREATE TABLE `mobile_receivers` (
  `mobile_id` int(10) NOT NULL,
  `mobile_no` varchar(20) NOT NULL,  
  `mobile_country_id`  int(11) NOT NULL ,
  `mobile_state_id`  int(11) NOT NULL,
  `mobile_city_id`  int(11) NOT NULL ,
  `status`  int(1) NOT NULL DEFAULT 1,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
   PRIMARY KEY (`mobile_id`),
   CONSTRAINT fk_mobile_country_id FOREIGN KEY (mobile_country_id) REFERENCES countries(id),
    CONSTRAINT fk_mobile_state_id FOREIGN KEY (mobile_state_id) REFERENCES states(id),
	 CONSTRAINT fk_mobile_city_id FOREIGN KEY (mobile_city_id) REFERENCES cities(id)
)  ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;

--
-- Table structure for table `email_receivers`
-- 

CREATE TABLE `email_receivers` (
  `email_id` int(10) NOT NULL,
  `email` varchar(100) NOT NULL,  
  `email_country_id`  int(11) NOT NULL ,
  `email_state_id`  int(11) NOT NULL,
  `email_city_id`  int(11) NOT NULL ,
  `status`  int(1) NOT NULL DEFAULT 1,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
   PRIMARY KEY (`email_id`),
   CONSTRAINT fk_email_country_id FOREIGN KEY (email_country_id) REFERENCES countries(id),
    CONSTRAINT fk_email_state_id FOREIGN KEY (email_state_id) REFERENCES states(id),
	 CONSTRAINT fk_email_city_id FOREIGN KEY (email_city_id) REFERENCES cities(id)
)  ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;







