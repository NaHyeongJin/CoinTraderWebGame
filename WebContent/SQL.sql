CREATE TABLE "COIN_USER" (
	"ID"	varchar2(20)		NOT NULL,
	"PW"	varchar2(32)		NOT NULL,
	"EMAIL1"	varchar2(50)		NOT NULL,
	"EMAIL2"	varchar2(50)		NOT NULL,
	"MONEY"	number(8)	DEFAULT 50000	NOT NULL,
	"REGDATE"	date	DEFAULT sysdate	NOT NULL,
	"EMAILCHECK"	number(1)	    DEFAULT 0 	NOT NULL,
	"PWCHECK"	number(1)	    DEFAULT 1 	NOT NULL
);

CREATE TABLE "COIN_QNA" (
	"ID"	varchar2(20)		NOT NULL,
	"SUBJECT"	varchar2(500)		NOT NULL,
	"CONTENTS"	varchar2(1500)		NOT NULL,
	"REGDATE"	date	DEFAULT sysdate	NOT NULL,
	"ANSWER"	varchar2(1500)		NULL
);

CREATE TABLE "COIN_MONEY" (
	"ID"	varchar2(20)		NOT NULL,
	"REGDATE"	date	DEFAULT sysdate	NOT NULL,
	"MONEY"	number(8)	DEFAULT 50000	NOT NULL
);

CREATE TABLE "COIN_RECEIPT" (
	"ID"	varchar2(20)		NOT NULL,
	"NUM"	number(4)		NOT NULL,
	"COUNT"	number(4)		NOT NULL,
	"REGDATE"	date	DEFAULT sysdate	NOT NULL,
	"PRICE"	number(8)		NOT NULL
);

CREATE TABLE "COIN_PRICE" (
	"NUM"	number(4)		NOT NULL,
	"TIME"	date		NOT NULL,
	"PRICE"	number(8)		NOT NULL
);

CREATE TABLE "COIN_LIST" (
	"NUM"	number(4)		NOT NULL,
	"NAME"	varchar2(20)		NOT NULL
);

ALTER TABLE "COIN_USER" ADD CONSTRAINT "PK_COIN_USER" PRIMARY KEY (
	"ID"
);

ALTER TABLE "COIN_LIST" ADD CONSTRAINT "PK_COIN_LIST" PRIMARY KEY (
	"NUM"
);

ALTER TABLE "COIN_QNA" ADD CONSTRAINT "FK_COIN_USER_TO_COIN_QNA_1" FOREIGN KEY (
	"ID"
)
REFERENCES "COIN_USER" (
	"ID"
) ON DELETE CASCADE;

ALTER TABLE "COIN_MONEY" ADD CONSTRAINT "FK_COIN_USER_TO_COIN_MONEY_1" FOREIGN KEY (
	"ID"
)
REFERENCES "COIN_USER" (
	"ID"
) ON DELETE CASCADE;

ALTER TABLE "COIN_RECEIPT" ADD CONSTRAINT "FK_COIN_USER_TO_aRECEIPT_1" FOREIGN KEY (
	"ID"
)
REFERENCES "COIN_USER" (
	"ID"
) ON DELETE CASCADE;

ALTER TABLE "COIN_RECEIPT" ADD CONSTRAINT "FK_COIN_LIST_TO_COIN_RECEIPT_1" FOREIGN KEY (
	"NUM"
)
REFERENCES "COIN_LIST" (
	"NUM"
) ON DELETE CASCADE;

ALTER TABLE "COIN_PRICE" ADD CONSTRAINT "FK_COIN_LIST_TO_COIN_PRICE_1" FOREIGN KEY (
	"NUM"
)
REFERENCES "COIN_LIST" (
	"NUM"
) ON DELETE CASCADE;