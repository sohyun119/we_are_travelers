CREATE TABLE `USER`(
`USER_CD` int NOT NULL auto_increment primary key,
`LOGIN_ID` varchar(16) NOT NULL,
`PASSWORD` varchar(128) NOT NULL,
`USER_NAME` varchar(16) NOT NULL,
`EMAIL` varchar(64) NOT NULL,
`PROFILE_IMG_PATH` varchar(256),
`CREATED_AT` timestamp NOT NULL,
`UPDATED_AT` timestamp
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `LIKE_LOCATION`(
`LOCATION_CD` int NOT NULL auto_increment primary key,
`USER_CD` int NOT NULL,
`LOCATION_NAME` varchar(32) NOT NULL,
`LATITUDE` varchar(16) NOT NULL,
`LONGITUDE` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `POST`(
`POST_CD` int NOT NULL auto_increment primary key,
`USER_CD` int NOT NULL,
`USER_NAME` varchar(16) NOT NULL,
`IMG_PATH_LIST` text NOT NULL,
`CONTENT` text,
`LOCATION_NAME` varchar(32) NOT NULL,
`LATITUDE` varchar(16) NOT NULL,
`LONGITUDE` varchar(16) NOT NULL,
`CREATED_AT` timestamp NOT NULL,
`UPDATED_AT` timestamp
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `COMMENT`(
`COMMENT_CD` int NOT NULL auto_increment primary key,
`POST_CD` int NOT NULL,
`USER_CD` int NOT NULL,
`USER_NAME` varchar(16) NOT NULL,
`COMMENT` varchar(256) NOT NULL,
`CREATED_AT` timestamp NOT NULL,
`UPDATED_AT` timestamp
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `LIKE`(
`LIKE_CD` int NOT NULL auto_increment primary key,
`POST_CD` int NOT NULL,
`USER_CD` int NOT NULL,
`USER_NAME` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `SUBSCRIBE`(
`SUBSCRIBE_CD` int NOT NULL auto_increment primary key,
`THIS_USER_CD` int NOT NULL,
`USER_CD` int NOT NULL,
`THIS_USER_NAME` varchar(16) NOT NULL,
`USER_NAME` varchar(16) NOT NULL,
`CREATED_AT` timestamp NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
