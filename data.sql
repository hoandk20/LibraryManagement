--Create database [Library]
USE [Library]
GO
/****** Object:  Table [dbo].[authors]    Script Date: 9/28/2021 11:06:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[authors](
	[authorID] [int] IDENTITY(1,1) NOT NULL,
	[name] [ntext] NULL,
 CONSTRAINT [PK_authors] PRIMARY KEY CLUSTERED 
(
	[authorID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[books]    Script Date: 9/28/2021 11:06:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[books](
	[BookID] [int] IDENTITY(1,1) NOT NULL,
	[bookName] [ntext] NULL,
	[quantity] [int] NULL,
	[authorId] [int] NULL,
	[cateId] [int] NULL,
 CONSTRAINT [PK_books] PRIMARY KEY CLUSTERED 
(
	[BookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[borrowDetail]    Script Date: 9/28/2021 11:06:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[borrowDetail](
	[borrowId] [int] IDENTITY(1,1) NOT NULL,
	[bookId] [int] NULL,
	[quantity] [int] NULL,
	[studentName] [ntext] NULL,
	[studentClass] [ntext] NULL,
	[studentId] [ntext] NULL,
	[timeGet] [date] NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_borrowDetail] PRIMARY KEY CLUSTERED 
(
	[borrowId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[category]    Script Date: 9/28/2021 11:06:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[CateId] [int] IDENTITY(1,1) NOT NULL,
	[CateName] [ntext] NULL,
 CONSTRAINT [PK_category] PRIMARY KEY CLUSTERED 
(
	[CateId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[login]    Script Date: 9/28/2021 11:06:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[login](
	[username] [nvarchar](30) NOT NULL,
	[password] [nvarchar](30) NULL,
 CONSTRAINT [PK_login] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[authors] ON 

INSERT [dbo].[authors] ([authorID], [name]) VALUES (1, N'Nguyễn Trãi')
INSERT [dbo].[authors] ([authorID], [name]) VALUES (2, N'Tô Hoài')
INSERT [dbo].[authors] ([authorID], [name]) VALUES (3, N'Hoài Linh')
INSERT [dbo].[authors] ([authorID], [name]) VALUES (4, N'Hoandk')
INSERT [dbo].[authors] ([authorID], [name]) VALUES (10, N'gió')
INSERT [dbo].[authors] ([authorID], [name]) VALUES (2006, N'hoan')
SET IDENTITY_INSERT [dbo].[authors] OFF
GO
SET IDENTITY_INSERT [dbo].[books] ON 

INSERT [dbo].[books] ([BookID], [bookName], [quantity], [authorId], [cateId]) VALUES (1, N'Ủng hộ miền trung', 2, 3, 3)
INSERT [dbo].[books] ([BookID], [bookName], [quantity], [authorId], [cateId]) VALUES (2, N'HarryPotter', 3, 2, 2)
INSERT [dbo].[books] ([BookID], [bookName], [quantity], [authorId], [cateId]) VALUES (3, N'Dế choắt', 5, 3, 1)
INSERT [dbo].[books] ([BookID], [bookName], [quantity], [authorId], [cateId]) VALUES (4, N'Tôi 20', 5, 1, 1)
INSERT [dbo].[books] ([BookID], [bookName], [quantity], [authorId], [cateId]) VALUES (5, N'tôi 20', 4, 10, 1)
INSERT [dbo].[books] ([BookID], [bookName], [quantity], [authorId], [cateId]) VALUES (1004, N'Tôi là ai', 3, 4, 2)
INSERT [dbo].[books] ([BookID], [bookName], [quantity], [authorId], [cateId]) VALUES (2005, N'toi', 4, 4, 2)
SET IDENTITY_INSERT [dbo].[books] OFF
GO
SET IDENTITY_INSERT [dbo].[borrowDetail] ON 

INSERT [dbo].[borrowDetail] ([borrowId], [bookId], [quantity], [studentName], [studentClass], [studentId], [timeGet], [status]) VALUES (1, 1, 1, N'Hoan', N'12e', N'a432', CAST(N'2021-09-25' AS Date), 0)
INSERT [dbo].[borrowDetail] ([borrowId], [bookId], [quantity], [studentName], [studentClass], [studentId], [timeGet], [status]) VALUES (2, 3, 1, N'H', N'12r', N'a123', CAST(N'2021-09-25' AS Date), 1)
INSERT [dbo].[borrowDetail] ([borrowId], [bookId], [quantity], [studentName], [studentClass], [studentId], [timeGet], [status]) VALUES (3, 3, 2, N'AB', N'12', N'12343', CAST(N'2021-09-24' AS Date), 1)
INSERT [dbo].[borrowDetail] ([borrowId], [bookId], [quantity], [studentName], [studentClass], [studentId], [timeGet], [status]) VALUES (1003, 2, 1, N'Abc', N'123', N'5345', CAST(N'2021-09-26' AS Date), 0)
INSERT [dbo].[borrowDetail] ([borrowId], [bookId], [quantity], [studentName], [studentClass], [studentId], [timeGet], [status]) VALUES (1005, 3, 2, N'qưe', N'qưe', N'ádda', CAST(N'2021-09-26' AS Date), 0)
SET IDENTITY_INSERT [dbo].[borrowDetail] OFF
GO
SET IDENTITY_INSERT [dbo].[category] ON 

INSERT [dbo].[category] ([CateId], [CateName]) VALUES (1, N'Hài Kịch')
INSERT [dbo].[category] ([CateId], [CateName]) VALUES (2, N'Phưu lưu')
INSERT [dbo].[category] ([CateId], [CateName]) VALUES (3, N'Kinh dị')
INSERT [dbo].[category] ([CateId], [CateName]) VALUES (4, N'Viễn tưởng')
INSERT [dbo].[category] ([CateId], [CateName]) VALUES (5, N'Ca nhạc')
SET IDENTITY_INSERT [dbo].[category] OFF
GO
INSERT [dbo].[login] ([username], [password]) VALUES (N'a', N'a')
INSERT [dbo].[login] ([username], [password]) VALUES (N'b', N'b')
INSERT [dbo].[login] ([username], [password]) VALUES (N'c', N'c')
INSERT [dbo].[login] ([username], [password]) VALUES (N'd', N'd')
GO
ALTER TABLE [dbo].[books]  WITH CHECK ADD  CONSTRAINT [FK_books_authors] FOREIGN KEY([authorId])
REFERENCES [dbo].[authors] ([authorID])
GO
ALTER TABLE [dbo].[books] CHECK CONSTRAINT [FK_books_authors]
GO
ALTER TABLE [dbo].[books]  WITH CHECK ADD  CONSTRAINT [FK_books_category] FOREIGN KEY([cateId])
REFERENCES [dbo].[category] ([CateId])
GO
ALTER TABLE [dbo].[books] CHECK CONSTRAINT [FK_books_category]
GO
ALTER TABLE [dbo].[borrowDetail]  WITH CHECK ADD  CONSTRAINT [FK_borrowDetail_books] FOREIGN KEY([bookId])
REFERENCES [dbo].[books] ([BookID])
GO
ALTER TABLE [dbo].[borrowDetail] CHECK CONSTRAINT [FK_borrowDetail_books]
GO
