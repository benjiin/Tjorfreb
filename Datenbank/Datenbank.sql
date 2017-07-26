USE [master]
GO
/****** Object:  Database [Tjorfreb]    Script Date: 26.07.2017 09:53:51 ******/
CREATE DATABASE [Tjorfreb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Tjorfreb', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\Tjorfreb.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Tjorfreb_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\Tjorfreb_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Tjorfreb] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Tjorfreb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Tjorfreb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Tjorfreb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Tjorfreb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Tjorfreb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Tjorfreb] SET ARITHABORT OFF 
GO
ALTER DATABASE [Tjorfreb] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Tjorfreb] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [Tjorfreb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Tjorfreb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Tjorfreb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Tjorfreb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Tjorfreb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Tjorfreb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Tjorfreb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Tjorfreb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Tjorfreb] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Tjorfreb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Tjorfreb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Tjorfreb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Tjorfreb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Tjorfreb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Tjorfreb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Tjorfreb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Tjorfreb] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Tjorfreb] SET  MULTI_USER 
GO
ALTER DATABASE [Tjorfreb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Tjorfreb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Tjorfreb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Tjorfreb] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [Tjorfreb]
GO
/****** Object:  Table [dbo].[adress]    Script Date: 26.07.2017 09:53:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[adress](
	[user_ID] [int] NOT NULL,
	[street] [nchar](10) NOT NULL,
	[housenumber] [nchar](10) NOT NULL,
	[city_ID] [int] NOT NULL,
 CONSTRAINT [PK_adress] PRIMARY KEY CLUSTERED 
(
	[user_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[bill]    Script Date: 26.07.2017 09:53:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[bill](
	[bill_ID] [nchar](10) NOT NULL,
	[shopping_cart] [nchar](10) NOT NULL,
 CONSTRAINT [PK_bill] PRIMARY KEY CLUSTERED 
(
	[bill_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[category]    Script Date: 26.07.2017 09:53:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[name] [nchar](10) NOT NULL,
	[category_ID] [int] NOT NULL,
 CONSTRAINT [PK_category_1] PRIMARY KEY CLUSTERED 
(
	[category_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[city]    Script Date: 26.07.2017 09:53:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[city](
	[postcode] [nchar](10) NOT NULL,
	[city] [nchar](10) NOT NULL,
	[city_ID] [int] NOT NULL,
 CONSTRAINT [PK_city] PRIMARY KEY CLUSTERED 
(
	[city_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[creditcard]    Script Date: 26.07.2017 09:53:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[creditcard](
	[creditcard_Adress] [nchar](10) NOT NULL,
	[verified] [bit] NOT NULL,
	[creditcard_ID] [int] NOT NULL,
 CONSTRAINT [PK_creditcard] PRIMARY KEY CLUSTERED 
(
	[creditcard_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[item]    Script Date: 26.07.2017 09:53:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[item](
	[item_ID] [int] NOT NULL,
	[category_ID] [int] NOT NULL,
	[name] [nchar](10) NOT NULL,
	[price] [float] NOT NULL,
	[is_offer] [bit] NOT NULL,
	[weight] [float] NOT NULL,
	[size] [float] NOT NULL,
	[usk18] [bit] NOT NULL,
	[unit_solded] [int] NOT NULL,
	[registration_date] [datetime] NULL,
 CONSTRAINT [PK_item] PRIMARY KEY CLUSTERED 
(
	[item_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[newsletter]    Script Date: 26.07.2017 09:53:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[newsletter](
	[user_ID] [int] NOT NULL,
	[category_ID] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[password_hash]    Script Date: 26.07.2017 09:53:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[password_hash](
	[user_ID] [int] NOT NULL,
	[password_hashed] [nchar](10) NOT NULL,
 CONSTRAINT [PK_password_hash] PRIMARY KEY CLUSTERED 
(
	[user_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[payment]    Script Date: 26.07.2017 09:53:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[payment](
	[sepa_ID] [int] NOT NULL,
	[payment_ID] [int] NOT NULL,
	[playpal_ID] [int] NOT NULL,
	[creditcard_ID] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[paypal]    Script Date: 26.07.2017 09:53:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[paypal](
	[paypal_Adress] [nchar](10) NOT NULL,
	[verified] [bit] NOT NULL,
	[paypal_ID] [int] NOT NULL,
 CONSTRAINT [PK_paypal] PRIMARY KEY CLUSTERED 
(
	[paypal_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[sepa]    Script Date: 26.07.2017 09:53:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sepa](
	[sepa_ID] [int] NOT NULL,
	[owner] [nchar](10) NOT NULL,
	[iban] [nchar](10) NOT NULL,
	[swift] [nchar](10) NOT NULL,
	[institute] [nchar](10) NOT NULL,
	[is_verified] [bit] NOT NULL,
 CONSTRAINT [PK_sepa] PRIMARY KEY CLUSTERED 
(
	[sepa_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[shopping_cart]    Script Date: 26.07.2017 09:53:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[shopping_cart](
	[shopping_cart_ID] [int] NOT NULL,
	[scp_ID] [int] NOT NULL,
 CONSTRAINT [PK_shopping_cart] PRIMARY KEY CLUSTERED 
(
	[shopping_cart_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[shopping_cart_elements]    Script Date: 26.07.2017 09:53:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[shopping_cart_elements](
	[scp_ID] [int] NOT NULL,
	[item_ID] [int] NOT NULL,
	[amount] [nchar](10) NOT NULL,
 CONSTRAINT [PK_shopping_cart_elements] PRIMARY KEY CLUSTERED 
(
	[scp_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[user]    Script Date: 26.07.2017 09:53:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[user_ID] [int] NOT NULL,
	[name] [nchar](10) NOT NULL,
	[lastname] [nchar](10) NOT NULL,
	[payment_ID] [int] NOT NULL,
	[reg_key] [nchar](10) NOT NULL,
	[is_activated] [bit] NOT NULL,
	[last_time_online] [datetime] NULL,
	[registration_date] [datetime] NOT NULL,
	[language] [nchar](10) NOT NULL,
	[gender] [bit] NOT NULL,
	[e_mail] [nchar](10) NOT NULL,
	[personal_ID] [bit] NOT NULL,
	[bill_ID] [nchar](10) NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[user_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Index [IX_adress]    Script Date: 26.07.2017 09:53:51 ******/
CREATE NONCLUSTERED INDEX [IX_adress] ON [dbo].[adress]
(
	[user_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_user]    Script Date: 26.07.2017 09:53:51 ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_user] ON [dbo].[user]
(
	[payment_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[adress]  WITH CHECK ADD  CONSTRAINT [FK_adress_city1] FOREIGN KEY([city_ID])
REFERENCES [dbo].[city] ([city_ID])
GO
ALTER TABLE [dbo].[adress] CHECK CONSTRAINT [FK_adress_city1]
GO
ALTER TABLE [dbo].[item]  WITH CHECK ADD  CONSTRAINT [FK_item_category] FOREIGN KEY([category_ID])
REFERENCES [dbo].[category] ([category_ID])
GO
ALTER TABLE [dbo].[item] CHECK CONSTRAINT [FK_item_category]
GO
ALTER TABLE [dbo].[newsletter]  WITH CHECK ADD  CONSTRAINT [FK_newsletter_category] FOREIGN KEY([category_ID])
REFERENCES [dbo].[category] ([category_ID])
GO
ALTER TABLE [dbo].[newsletter] CHECK CONSTRAINT [FK_newsletter_category]
GO
ALTER TABLE [dbo].[newsletter]  WITH CHECK ADD  CONSTRAINT [FK_newsletter_user] FOREIGN KEY([user_ID])
REFERENCES [dbo].[user] ([user_ID])
GO
ALTER TABLE [dbo].[newsletter] CHECK CONSTRAINT [FK_newsletter_user]
GO
ALTER TABLE [dbo].[password_hash]  WITH CHECK ADD  CONSTRAINT [FK_password_hash_user] FOREIGN KEY([user_ID])
REFERENCES [dbo].[user] ([user_ID])
GO
ALTER TABLE [dbo].[password_hash] CHECK CONSTRAINT [FK_password_hash_user]
GO
ALTER TABLE [dbo].[payment]  WITH CHECK ADD  CONSTRAINT [FK_payment_creditcard] FOREIGN KEY([creditcard_ID])
REFERENCES [dbo].[creditcard] ([creditcard_ID])
GO
ALTER TABLE [dbo].[payment] CHECK CONSTRAINT [FK_payment_creditcard]
GO
ALTER TABLE [dbo].[payment]  WITH CHECK ADD  CONSTRAINT [FK_payment_paypal] FOREIGN KEY([playpal_ID])
REFERENCES [dbo].[paypal] ([paypal_ID])
GO
ALTER TABLE [dbo].[payment] CHECK CONSTRAINT [FK_payment_paypal]
GO
ALTER TABLE [dbo].[payment]  WITH CHECK ADD  CONSTRAINT [FK_payment_sepa] FOREIGN KEY([sepa_ID])
REFERENCES [dbo].[sepa] ([sepa_ID])
GO
ALTER TABLE [dbo].[payment] CHECK CONSTRAINT [FK_payment_sepa]
GO
ALTER TABLE [dbo].[payment]  WITH CHECK ADD  CONSTRAINT [FK_payment_user] FOREIGN KEY([payment_ID])
REFERENCES [dbo].[user] ([payment_ID])
GO
ALTER TABLE [dbo].[payment] CHECK CONSTRAINT [FK_payment_user]
GO
ALTER TABLE [dbo].[shopping_cart]  WITH CHECK ADD  CONSTRAINT [FK_shopping_cart_shopping_cart_elements] FOREIGN KEY([scp_ID])
REFERENCES [dbo].[shopping_cart_elements] ([scp_ID])
GO
ALTER TABLE [dbo].[shopping_cart] CHECK CONSTRAINT [FK_shopping_cart_shopping_cart_elements]
GO
ALTER TABLE [dbo].[shopping_cart]  WITH CHECK ADD  CONSTRAINT [FK_shopping_cart_user] FOREIGN KEY([shopping_cart_ID])
REFERENCES [dbo].[user] ([user_ID])
GO
ALTER TABLE [dbo].[shopping_cart] CHECK CONSTRAINT [FK_shopping_cart_user]
GO
ALTER TABLE [dbo].[shopping_cart_elements]  WITH CHECK ADD  CONSTRAINT [FK_shopping_cart_elements_item] FOREIGN KEY([item_ID])
REFERENCES [dbo].[item] ([item_ID])
GO
ALTER TABLE [dbo].[shopping_cart_elements] CHECK CONSTRAINT [FK_shopping_cart_elements_item]
GO
ALTER TABLE [dbo].[user]  WITH CHECK ADD  CONSTRAINT [FK_user_adress] FOREIGN KEY([user_ID])
REFERENCES [dbo].[adress] ([user_ID])
GO
ALTER TABLE [dbo].[user] CHECK CONSTRAINT [FK_user_adress]
GO
ALTER TABLE [dbo].[user]  WITH CHECK ADD  CONSTRAINT [FK_user_bill] FOREIGN KEY([bill_ID])
REFERENCES [dbo].[bill] ([bill_ID])
GO
ALTER TABLE [dbo].[user] CHECK CONSTRAINT [FK_user_bill]
GO
USE [master]
GO
ALTER DATABASE [Tjorfreb] SET  READ_WRITE 
GO
