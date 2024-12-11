CREATE DATABASE IF NOT EXISTS `cdc_cricbrik`;

USE `cdc_cricbrik`;

DROP DATABASE IF EXISTS `cdc_cricbrik`;

SELECT * FROM `players`;

-- custom query to just update team name (group)
-- add validation for role