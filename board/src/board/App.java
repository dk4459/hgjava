package board;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		UserDAO udao = new UserDAO();
		BoardDAO bdao = new BoardDAO();
		DabsDAO ddao = new DabsDAO();
		boolean run = true;
		boolean ru = true;
		int menu = 0;
		int men = 0;
		String id = null;

		while (run) {
			System.out.println("1.로그인 2.회원가입");
			menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
				System.out.println("로그인 해주세요");
				// 로그인
				int cnt = 0;
				while (run) {
					System.out.println("id를 입력하세요");
					id = scn.nextLine();
					System.out.println("pw를 입력하세요");
					String pw = scn.nextLine();
					if (udao.login(id, pw) == 0) {
						System.out.println("환영합니다");
						run = false;

					} else if (udao.login(id, pw) == -1) {
						System.out.println("입력하신 정보가 맞지 않습니다.");
						cnt++;

						if (cnt == 3) {
							System.out.println("계정찾기를 하시겠습니까. 'yes''no'로 입력해주세요");
							String yes = scn.nextLine();
							if ("yes".equalsIgnoreCase(yes)) {

								// 아이디 비밀번호계정찾기
								cnt = 0;

								while (run) {
									System.out.println("이름을 입력하세요");
									String name = scn.nextLine();
									System.out.println("전화번호 입력하세요");
									String phone = scn.nextLine();
									if (udao.serchInf(name, phone) == true) {
										System.out.println("조회 성공 하셨습니다.");
										break;
									} else if (udao.serchInf(name, phone) == false) {
										System.out.println("입력하신 정보가 맞지 않습니다.");
										cnt++;
										if (cnt == 3) {
											System.out.println("횟수초과");
											break;
										}
									}
								}
							} // yesif문 끝
							else if ("no".equalsIgnoreCase(yes)) {
								break;
							} else {
								System.out.println("잘못입력해 처음으로 돌아갑니다");
								break;
							}
						} // cnt ifans끝
					}
				} //// 로그인끝
			} else if (menu == 2) { // 회원 가입
				// 회원가입
				System.out.println("id>>");
				id = scn.nextLine();
				System.out.println("pw>>");
				String pw = scn.nextLine();
				System.out.println("phone>>");
				String phone = scn.nextLine();
				System.out.println("name>>");
				String name = scn.nextLine();
				System.out.println("nic>>");
				String nic = scn.nextLine();
				try {
					User user = new User(id, pw, phone, name, nic);
					if (udao.userAdd(user)) {
						System.out.println("정상적 등록");
					} else {
						System.out.println("등록 에러");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} // 로그인 아예 끝
		if (run == false) {// 접속
			while (ru) {
				System.out.println("1.게시글 목록 2.게시글 등록 3.검색 4.본인회원정보조회 5.자기가 쓴 글 조회 6.회원 탈퇴");
				System.out.print("선택");
				menu = scn.nextInt();
				scn.nextLine();
				switch (menu) {// 게시글 목록
				case 1: // 게시글목록
					System.out.println("조회할 카테고리를 입력하세요");
					String cate = scn.nextLine();
					int page = 1;
					while (true) {
						System.out.println("게시글번호 제목 아이디 닉네임 카테고리");
						System.out.println("======================================");
						List<Board> list = bdao.getList(cate, page);
						for (Board boa : list) {
							System.out.println(boa.getBoardNo() + "     " + boa.getBoardTitle() + " " + boa.getUserId()
									+ " " + boa.getUserNic() + "   " + boa.getCate());

						}
						int totalCnt = bdao.getTotalCnt(cate);
						int lastPage = (int) Math.ceil(totalCnt / 5.0);
						for (int i = 1; i <= lastPage; i++) {
							System.out.printf("%3d", i);
						}
						System.out.println();
						System.out.println("(-1 내용 검색) (-2 종료) (n 찾을페이지)");
						System.out.print("페이지 >>");
						page = scn.nextInt();
						scn.nextLine();
						if (page == -2) {// 종료
							break;
						} else if (page == -1) { // 내용검색
							System.out.println("원하는 내용의 글번호를 눌러주세요");
							while (true) {
								int no = scn.nextInt();
								scn.nextLine();
								List<Board> list1 = bdao.intoList(no);
								List<Dabs> dabs = ddao.getList(no);
								for (Board boa : list1) {

									System.out.println(
											"====================================================================================================");
									System.out.println("제목: " + boa.getBoardTitle() + "                   닉네임: "
											+ boa.getUserNic() + "   작성일자: " + boa.getBoardDate());
									System.out.println(
											"====================================================================================================");
									System.out.println("내용");
									System.out.println(boa.getBoardCon());
									System.out.println(
											"====================================================================================================");
									System.out.println("댓글");
								}
								for (Dabs dao : dabs) {
									System.out.println("id: " + dao.getUserId() + "  ||  " + dao.getDap());
								}

								System.out.println(
										"=========================================================================================");
								System.out.println("(나가기 -1) (댓글달기 1) (글수정 2) (해당글 삭제 3)");
								int dap = scn.nextInt();
								scn.nextLine();
								if (dap == 1) { // 댓글 만들기

									System.out.print("\n 해당 아이디 \n");
									String id1 = scn.nextLine();
									System.out.println("댓글을 입력하세요");
									String nae = scn.nextLine();
									try {
										Dabs dab = new Dabs(id1, no, nae);
										if (ddao.insertDab(dab)) {
											System.out.println("등록완료");
											break;
										} else {
											System.out.println("등록에러");
											break;
										}
									} catch (Exception e) {
										e.printStackTrace();
									}

								} else if (dap == 2) {// 게시글 수정
									System.out.println("1.제목수정 2.내용수정");
									int modify = scn.nextInt();
									scn.nextLine();
									int cnt = 0;
									for (Board boa : list) {
										if (modify == 1) {
											if (id.equals(boa.getUserId())) {
												System.out.println("수정할 제목을 작성해주세요");
												String title = scn.nextLine();
												Board boar = new Board();
												boar.setBoardNo(no);
												boar.setUserId(id);
												boar.setBoardTitle(title);
												if (bdao.updateTitle(boar)) {
													System.out.println("정상작동");
													cnt++;
													break;
												}
											}
										} else if (modify == 2) {
											if (id.equals(boa.getUserId())) {
												System.out.println("수정할 내용을 작성해주세요");
												String content = scn.nextLine();
												Board boar = new Board();
												boar.setBoardNo(no);
												boar.setUserId(id);
												boar.setBoardCon(content);
												if (bdao.updateContent(boar)) {
													System.out.println("정상작동");
													cnt++;
													break;
												}
											}
										}
									}
									if (cnt == 0) {
										System.out.println("권한이 없는 사용자입니다.");
									}
									break;

								} else if (dap == 3) {
									System.out.println("해당글을 삭제하시겠습니까? yes no");
									String yes = scn.nextLine();
									int cnt = 0;
									for (Board boa : list) {
										if (yes.equals(yes)) {
											if (id.equals(boa.getUserId())) {
												if (bdao.removeBoard(no, id)) {
													System.out.println("정상작동");
													cnt++;
													break;
												}
											}
										}
									}
									if (cnt == 0) {
										System.out.println("권한이 없는 사용자입니다.");
									}
									break;
								}

								else if (dap == -1) {// 종료
									break;
								}
							}
							page = 1;
						}
					} // case 1문 전체 끝
					break;
				case 2:// 게시글 작성
					System.out.println("글 제목을 입력하세요");
					String title = scn.nextLine();
					System.out.println("내용을입력하세요");
					String con = scn.nextLine();
					System.out.println("해당 카테고리를 입력하세요");
					String cate1 = scn.nextLine();
					Board board = new Board(id, title, con, cate1);

					if (bdao.insertBoard(board)) {
						System.out.println("정상등록");
					} else {
						System.out.println("등록에러");
					}
					break;

				case 3: // 검색
					System.out.println("찾고싶은신 글제목을말히세요");
					String title1 = scn.nextLine();
					int page1 = 1;
					while (true) {
						System.out.println("게시글번호 제목 아이디 닉네임 카테고리");
						System.out.println("======================================");
						List<Board> list = bdao.searchList(title1, page1);
						for (Board board1 : list) {
							System.out.println(board1.getBoardNo() + "   " + board1.getBoardTitle() + " "
									+ board1.getUserId() + "   " + board1.getUserNic() + "   " + board1.getCate());
						}
						int totalCnt = bdao.getTotalCnt(title1);
						int lastPage = (int) Math.ceil(totalCnt / 5.0);
						for (int i = 1; i <= lastPage; i++) {
							System.out.printf("%3d", 1);
						}
						System.out.println();
						System.out.println("(-1 내용 검색) (-2 종료) (n 찾을페이지)");
						System.out.println("페이지 >>");
						page1 = scn.nextInt();
						scn.nextLine();
						if (page1 == -2) { // 종료
							break;
						} else if (page1 == -1) {
							System.out.println("원하는 내용의 글번호를 눌러주세요");
							while (true) {
								int no = scn.nextInt();
								scn.nextLine();
								List<Board> list1 = bdao.intoList(no);
								List<Dabs> dabs = ddao.getList(no);
								for (Board boa : list1) {

									System.out.println(
											"====================================================================================================");
									System.out.println("제목: " + boa.getBoardTitle() + "                   닉네임: "
											+ boa.getUserNic() + "   작성일자: " + boa.getBoardDate());
									System.out.println(
											"====================================================================================================");
									System.out.println("내용");
									System.out.println(boa.getBoardCon());
									System.out.println(
											"====================================================================================================");
									System.out.println("댓글");
								}
								for (Dabs dao : dabs) {
									System.out.println("id: " + dao.getUserId() + "  ||  " + dao.getDap());
								}

								System.out.println(
										"=========================================================================================");
								System.out.println("(나가기 -1) (댓글달기 1) (글수정2) (글삭제 3)");
								int dap = scn.nextInt();
								scn.nextLine();
								if (dap == 1) { // 댓글 만들기

									System.out.print("\n 해당 아이디 \n");
									String id1 = scn.nextLine();
									System.out.println("댓글을 입력하세요");
									String nae = scn.nextLine();

									try {
										Dabs dab = new Dabs(id1, no, nae);
										if (ddao.insertDab(dab)) {
											System.out.println("등록완료");
											break;
										} else {
											System.out.println("등록에러");
											break;
										}
									} catch (Exception e) {
										e.printStackTrace();
									}

								} else if (dap == 2) {// 게시글 수정
									System.out.println("1.제목수정 2.내용수정");
									int modify = scn.nextInt();
									scn.nextLine();
									int cnt = 0;
									for (Board boa : list) {
										if (modify == 1) {
											if (id.equals(boa.getUserId())) {
												System.out.println("수정할 제목을 작성해주세요");
												String title2 = scn.nextLine();
												Board boar = new Board();
												boar.setBoardNo(no);
												boar.setUserId(id);
												boar.setBoardTitle(title2);
												if (bdao.updateTitle(boar)) {
													System.out.println("정상작동");
													cnt++;
													break;
												}
											}
										} else if (modify == 2) {
											if (id.equals(boa.getUserId())) {
												System.out.println("수정할 내용을 작성해주세요");
												String content = scn.nextLine();
												Board boar = new Board();
												boar.setBoardNo(no);
												boar.setUserId(id);
												boar.setBoardCon(content);
												if (bdao.updateContent(boar)) {
													System.out.println("정상작동");
													break;
												}
											}
										}
									}
									if (cnt == 0) {
										System.out.println("권한이 없는 사용자입니다.");
									}
									break;

								} else if (dap == 3) {
									System.out.println("해당글을 삭제하시겠습니까? yes no");
									String yes = scn.nextLine();
									int cnt = 0;
									for (Board boa : list) {
										if (yes.equals(yes)) {
											if (id.equals(boa.getUserId())) {
												if (bdao.removeBoard(no, id)) {
													System.out.println("정상작동");
													cnt++;
													break;
												}
											}
										}
									}
									if (cnt == 0) {
										System.out.println("권한이 없는 사용자입니다.");
									}
									break;
								} else if (dap == -1) {
									break;
								}
							}
						}
					}
					break;

				case 4:// 정보 조회
					List<User> list = null;
					int cnt = 0;
					String id1 = null;
					String pw = null;
					boolean good = true;
					while (good) {
						System.out.println("id를 입력하세요");
						id1 = scn.nextLine();
						System.out.println("pw를 입력하세요");
						pw = scn.nextLine();
						list = udao.userInf(id1, pw);

						if (udao.userInf(id1, pw) == null) {
							System.out.println("회원정보가 맞지 않습니다");
							cnt++;
							if (cnt == 3) {
								System.out.println("3회초과하여 프로그램이 종료됩니다");
								good = false;

							}
						} else if (!id.equals(id1)) {
							System.out.println("로그인하신 정보와 입력하신 정보하신 정보가 다릅니다");
							cnt++;
						} else if (udao.userInf(id1, pw) != null) {
							break;
						}

					}
					while (good) {
						list = udao.userInf(id1, pw);
						System.out.println("아이디   비밀번호    연락처      이름    가입일자   닉네임");
						System.out.println("============================================");
						for (User user : list) {
							System.out.println(user.getUserId() + " " + user.getUserPw() + " " + user.getUserPhone()
									+ " " + user.getUserName() + "   " + user.getUserDate() + " " + user.getUserNic()
									+ " ");

						}

						System.out.println("(회원정보 수정 1) (종료 2)");

						int modify = Integer.parseInt(scn.nextLine());
						if (modify == 1) {
							System.out.println("수정할 목록을 말씀해주세요");
							System.out.println("1.비밀번호 2.연락처 3.이름  4.닉네임");
							int choice = Integer.parseInt(scn.nextLine());
							if (choice == 1) {
								System.out.println("수정 할 비밀번호를 입력해주세요");
								String pw1 = scn.nextLine();
								User user = new User();
								user.setUserId(id1);
								user.setUserPw(pw1);

								if (udao.pwModify(user)) {
									System.out.println("변경완료되었습니다");
								} else {
									System.out.println("변경이 불가합니다.");
								}
							} else if (choice == 2) {
								System.out.println("수정 할 연락처를 입력해주세요");
								String phone = scn.nextLine();
								User user = new User();
								user.setUserId(id1);
								user.setUserPhone(phone);

								if (udao.phoneModify(user)) {
									System.out.println("변경완료되었습니다");
								} else {
									System.out.println("변경이 불가합니다.");
								}

							} else if (choice == 3) {
								System.out.println("수정 할 이름을 입력해주세요");
								String name = scn.nextLine();
								User user = new User();
								user.setUserId(id1);
								user.setUserName(name);

								if (udao.nameModify(user)) {
									System.out.println("변경완료되었습니다");

								} else {
									System.out.println("변경이 불가합니다.");
								}

							} else if (choice == 4) {
								System.out.println("수정 할 닉네임을 입력해주세요");
								String nic = scn.nextLine();
								User user = new User();
								user.setUserId(id1);
								user.setUserNic(nic);

								if (udao.nicModify(user)) {
									System.out.println("변경완료되었습니다");

								} else {
									System.out.println("변경이 불가합니다.");
								}

							} else {
								System.out.println("정확한 입력을 해주세요");
							}

						} else if (modify == 2) {
							System.out.println("종료하겠습니다");
							break;
						} else {
							System.out.println("정확한 임력값을 넣어주세요");
						}

					}
					break;// case 4 끝)
				case 5: // 자기가 쓴 글 조회
					int page2 = 1;
					while (true) {
						List<Board> list1 = bdao.getMyList(id, page2);
						System.out.println("게시글번호 제목 아이디 닉네임 카테고리");
						System.out.println("======================================");
						for (Board boa : list1) {
							System.out.println(boa.getBoardNo() + "     " + boa.getBoardTitle() + " " + boa.getUserId()
									+ " " + boa.getUserNic() + "   " + boa.getCate());
						}
						int totalCnt = bdao.getTotalCnt(id);
						int lastPage = (int) Math.ceil(totalCnt / 5.0);
						for (int i = 1; i <= lastPage; i++) {
							System.out.printf("%3d", i);
						}
						System.out.println();
						System.out.println("(-1 내용 검색) (-2 종료) (n 찾을페이지)");
						System.out.print("페이지 >>");
						page2 = scn.nextInt();
						scn.nextLine();

						if (page2 == -2) {// 종료
							break;
						} else if (page2 == -1) { // 내용검색
							System.out.println("원하는 내용의 글번호를 눌러주세요");
							while (true) {
								int no = scn.nextInt();
								scn.nextLine();
								List<Board> list2 = bdao.intoList(no);
								List<Dabs> dabs = ddao.getList(no);
								for (Board boa : list2) {

									System.out.println(
											"====================================================================================================");
									System.out.println("제목: " + boa.getBoardTitle() + "                   닉네임: "
											+ boa.getUserNic() + "   작성일자: " + boa.getBoardDate());
									System.out.println(
											"====================================================================================================");
									System.out.println("내용");
									System.out.println(boa.getBoardCon());
									System.out.println(
											"====================================================================================================");
									System.out.println("댓글");
								}
								for (Dabs dao : dabs) {
									System.out.println("id: " + dao.getUserId() + "  ||  " + dao.getDap());
								}

								System.out.println(
										"=========================================================================================");
								System.out.println("(나가기 -1) (댓글달기 1) (글수정 2) (해당글 삭제 3)");
								int dap = scn.nextInt();
								scn.nextLine();
								if (dap == 1) { // 댓글 만들기

									System.out.print("\n 해당 아이디 \n");
									String id2 = scn.nextLine();
									System.out.println("댓글을 입력하세요");
									String nae = scn.nextLine();
									try {
										Dabs dab = new Dabs(id2, no, nae);
										if (ddao.insertDab(dab)) {
											System.out.println("등록완료");
											break;
										} else {
											System.out.println("등록에러");
											break;
										}
									} catch (Exception e) {
										e.printStackTrace();
									}

								} else if (dap == 2) {// 게시글 수정
									System.out.println("1.제목수정 2.내용수정");
									int modify = scn.nextInt();
									scn.nextLine();
									int cnt1 = 0;
									for (Board boa : list1) {
										if (modify == 1) {
											if (id.equals(boa.getUserId())) {
												System.out.println("수정할 제목을 작성해주세요");
												String title2 = scn.nextLine();
												Board boar = new Board();
												boar.setBoardNo(no);
												boar.setUserId(id);
												boar.setBoardTitle(title2);
												if (bdao.updateTitle(boar)) {
													System.out.println("정상작동");
													cnt1++;
													break;
												}
											}
										} else if (modify == 2) {
											if (id.equals(boa.getUserId())) {
												System.out.println("수정할 내용을 작성해주세요");
												String content = scn.nextLine();
												Board boar = new Board();
												boar.setBoardNo(no);
												boar.setUserId(id);
												boar.setBoardCon(content);
												if (bdao.updateContent(boar)) {
													System.out.println("정상작동");
													cnt1++;
													break;
												}
											}
										}
									}
									if (cnt1 == 0) {
										System.out.println("권한이 없는 사용자입니다.");
									}
									break;

								} else if (dap == 3) {
									System.out.println("해당글을 삭제하시겠습니까? yes no");
									String yes = scn.nextLine();
									int cnt1 = 0;
									for (Board boa : list1) {
										if (yes.equals(yes)) {
											if (id.equals(boa.getUserId())) {
												if (bdao.removeBoard(no, id)) {
													System.out.println("정상작동");
													cnt1++;
													break;
												}
											}
										}
									}
									if (cnt1 == 0) {
										System.out.println("권한이 없는 사용자입니다.");
									}
									break;
								}

								else if (dap == -1) {// 종료
									break;
								}
							}
							page2 = 1;
						}
					}

					break;// case 5 끝
				case 6: //회원 탈퇴
					System.err.println("정말로 삭제하실려면 아이디 비밀번호를 입력해주세요");
					System.err.println("아이디");
					String overId = scn.nextLine();
					System.out.println("비밀번호");
					String overPw = scn.nextLine();
					if(overId.equals(id)) {
						if(udao.removeUser(overId, overPw)) {
							System.out.println("정상적으로 회원탈퇴하였습니다 다음에 또 찾아주세요");
						}else {
							System.err.println("회원정보가 맞지 않습니다.");
						}
						break;
					}
				}// switch 문 끝
			} // 게시판 while문 끝
		} // 게시판 메서드 if 끝
	}// 메인메소드끝
}// 클래스끝