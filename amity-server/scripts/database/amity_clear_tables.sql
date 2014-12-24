use `amity_dev_univer`;

DROP TABLE IF EXISTS `text_message`;
DROP TABLE IF EXISTS `agreement_audit`;
DROP TABLE IF EXISTS `help_request_audit`;
DROP TABLE IF EXISTS `itinerary_audit`;
DROP TABLE IF EXISTS `facebook_user_audit`;
DROP TABLE IF EXISTS `amity_user_audit`;
DROP TABLE IF EXISTS `city_audit`;
DROP TABLE IF EXISTS `region_audit`;
DROP TABLE IF EXISTS `country_audit`;

DROP TABLE IF EXISTS `amity_audit_revision`;

DROP TABLE IF EXISTS `agreement`;
DROP TABLE IF EXISTS `help_request`;
DROP TABLE IF EXISTS `itinerary`;
DROP TABLE IF EXISTS `facebook_user`;
DROP TABLE IF EXISTS `amity_user`;

--
-- Tables below are reference data tables and require additional effort to setup
--
DROP TABLE IF EXISTS `city`;
DROP TABLE IF EXISTS `region`;
DROP TABLE IF EXISTS `country`;
