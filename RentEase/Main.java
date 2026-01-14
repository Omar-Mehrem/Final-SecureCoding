package finalomarmehrem;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static int numberOfAttemptedlogins = 3;
	public static int numberOfAttemptedUpdate = 3;

	public static void main(String[] args) {

		int numOfChoice;
		Scanner scan = new Scanner(System.in);
		PasswordPolicy policy = new PasswordPolicy();

		boolean exitSystem = true;
		while (exitSystem) {
			System.out.println("Welcome to RentEase");
			System.out.println("Please Choose According To Numbers");
			System.out.println("Are you: ");
			System.out.println("1. Customer"); // Done
			System.out.println("2. Rental Agent"); // Done 100%
			System.out.println("3. Maintenance Staff"); // Done 100%
			System.out.println("4. System Admin"); // Done 100%
			System.out.println("5. Exit");

			try {
				numOfChoice = scan.nextInt();

				if (numOfChoice == 1) {

					int countOfAttemptedlogin = 0;
					int countOfAttempteUpdateInfo = 0;

					System.out.println("Please Choose According To Numbers: ");
					System.out.println("1. Login");
					System.out.println("2. Register");
					System.out.println("3. Exit");

					try {

						int customerChoice = scan.nextInt();

						if (customerChoice == 1) {

							System.out.println("Enter your name: ");
							String name = scan.next();

							System.out.println("Enter your password: ");
							String password = scan.next();

							if (PasswordPolicy.isValidPassword(password, policy)) {

								CusLogin cus = new CusLogin();
								boolean validate = cus.customerLogin(name, password);

								if (validate == true) {
									System.out.println("Login Successfully");
									System.out.println("Welcome " + name);

									MyLogger.writeToLog("Customer login Successfully useing username: " + name
											+ ", Pass: " + password);

									boolean exitCustomer = false;
									while (!exitCustomer) {

										try {

											System.out.println("Please Choose According To Numbers: ");
											System.out.println("1. View all Vehicles");
											System.out.println("2. Update my profile");
											System.out.println("3. Exit");

											int choice = scan.nextInt();

											if (choice == 1) {

												ViewAndUpdateVehicles view = new ViewAndUpdateVehicles();
												view.info();

											} else if (choice == 2) {

												UpdateCusData up = new UpdateCusData();

												for (int s = 0; s < numberOfAttemptedUpdate; s++) {

													try {

														System.out.println("Enter your name: ");
														String checkName = scan.next();

														System.out.println("Enter your password: ");
														String checkPass = scan.next();

														if (PasswordPolicy.isValidPassword(checkPass, policy)) {

															int check = up.info(checkName, checkPass);

															if (check != 0) {

																try {

																	System.out.println(
																			"Please Choose According To Numbers: ");
																	System.out.println("1. Update name");
																	System.out.println("2. Update password");
																	System.out.println("3. Update phone number");
																	System.out.println("4. Update License number");

																	int upChoice = scan.nextInt();

																	if (upChoice == 1) {

																		System.out.println("Enter the new name: ");
																		String newName = scan.next();

																		up.updateName(check, newName);
																		break;
																	} else if (upChoice == 2) {

																		System.out.println("Enter the new password: ");
																		String newPass = scan.next();

																		up.updatePass(check, newPass);
																		break;
																	} else if (upChoice == 3) {

																		System.out.println(
																				"Enter the new phone number: ");
																		long newPhoneNum = scan.nextLong();

																		up.updatephoneNum(check, newPhoneNum);
																		break;
																	} else if (upChoice == 4) {

																		System.out
																				.println("Enter the License number: ");
																		long newLicenseNum = scan.nextLong();

																		up.updateLicense(check, newLicenseNum);
																		break;
																	} else {

																		System.out.println("Invalid Number");
																	}

																} catch (InputMismatchException e) {
																	System.out.println("SOMETHING WRONG");
																	MyLogger.writeToLog("Exception ::", e);
																}

															} else {
																System.out.println("Invalid name or password");
																countOfAttempteUpdateInfo++;

																if (countOfAttempteUpdateInfo == numberOfAttemptedUpdate) {
																	up.lock(name, password);
																	MyLogger.writeToLog("locked th account username: "
																			+ name + ", Password: " + password);

																}
															}

														} else {
															System.out.println("Password not valid");

															countOfAttempteUpdateInfo++;

															if (countOfAttempteUpdateInfo == numberOfAttemptedUpdate) {
																up.lock(name, password);
																MyLogger.writeToLog("locked th account username: "
																		+ name + ", Password: " + password);

															}

														}

													} catch (InputMismatchException e) {
														System.out.println("SOMETHING WRONG");
														MyLogger.writeToLog("Exception ::", e);
													}
												}
											} else if (choice == 3) {

												exitCustomer = true;

											} else {
												System.out.println("Invalid name, password or the account lock");

											}

										} catch (InputMismatchException e) {
											System.out.println("SOMETHING WRONG");
											MyLogger.writeToLog("Exception ::", e);
										}
									}

								} else {
//									MyLogger.writeToLog("login Invalid useing user:" + name + ", Pass:"+ pass);

									System.out.println("Invalid name or password");

									countOfAttemptedlogin++;
									if (countOfAttemptedlogin == numberOfAttemptedlogins) {
										System.out.println("The number of attempts exceeded");
										break;
									}

								}

							} else {
								System.out.println("Password not valid");
							}

						} else if (customerChoice == 2) {

							CusRegister cus = new CusRegister();
							cus.customerRegister();

						} else {

							System.out.println("Invalid Number");
						}

					} catch (InputMismatchException e) {
						System.out.println("SOMETHING WRONG");
						MyLogger.writeToLog("Exception ::", e);
					}

				} else if (numOfChoice == 2) {

					System.out.println("Enter your name: ");
					String name = scan.next();

					System.out.println("Enter your password: ");
					String password = scan.next();

					if (PasswordPolicy.isValidPassword(password, policy)) {

						RentalAgentLogin ren = new RentalAgentLogin();
						boolean validate = ren.rentalAgentLogin(name, password);

						if (validate == true) {
							MyLogger.writeToLog("Rental Agent login Successfully useing username: " + name
									+ ", Password: " + password);

							System.out.println("Login Successfully");
							System.out.println("Welcome " + name);

							boolean exit = true;
							while (exit) {

								try {

									System.out.println("Please Choose According To Numbers: ");
									System.out.println("1. Register new maintenance staff");
									System.out.println("2. Add new vehicles");
									System.out.println("3. View and update Maintenance Staff");
									System.out.println("4. View and update vehicles");
									System.out.println("5. Exit");

									int choice = scan.nextInt();

									ViewAndUpdateVehicles vauv = new ViewAndUpdateVehicles();
									ViewAndUpdateMainteneance vaum = new ViewAndUpdateMainteneance();

									if (choice == 1) {

										AddMaintenanceStaff regStaff = new AddMaintenanceStaff();
										regStaff.add();

									} else if (choice == 2) {

										AddVehicles vehicles = new AddVehicles();
										vehicles.add();

									} else if (choice == 3) {

										boolean back = false;
										while (!back) {
											System.out.println("Please Choose According To Numbers: ");
											System.out.println("1. View all Maintenance Staff");
											System.out.println("2. Update name");
											System.out.println("3. Update phone number");
											System.out.println("4. Update License number");
											System.out.println("5. Back");

											try {

												int choice1 = scan.nextInt();
												if (choice1 == 1) {

													vaum.info();

												} else if (choice1 == 2) {

													vaum.info();
													try {

														System.out.println("Enter number of line: ");
														int lineNum = scan.nextInt();

														System.out.println("enter the new name: ");
														String newName = scan.next();

														vaum.updateName(lineNum, newName);

													} catch (InputMismatchException e) {
														System.out.println("SOMETHING WRONG");
														MyLogger.writeToLog("Exception ::", e);
													}

												} else if (choice1 == 3) {

													vaum.info();
													try {

														System.out.println("Enter number of line: ");
														int lineNum = scan.nextInt();

														System.out.println("enter the new phone number: ");
														long newPhoneNum = scan.nextLong();

														vaum.updatephoneNum(lineNum, newPhoneNum);

													} catch (InputMismatchException e) {
														System.out.println("SOMETHING WRONG");
														MyLogger.writeToLog("Exception ::", e);
													}

												} else if (choice1 == 4) {

													vaum.info();
													try {

														System.out.println("Enter number of line: ");
														int lineNum = scan.nextInt();

														System.out.println("enter the new Licensee number: ");
														Long newLicense = scan.nextLong();

														vaum.updateLicense(lineNum, newLicense);

													} catch (InputMismatchException e) {
														System.out.println("SOMETHING WRONG");
														MyLogger.writeToLog("Exception ::", e);
													}

												} else if (choice1 == 5) {

													back = true;

												} else {

													System.out.println("Invalid Number");
												}

											} catch (InputMismatchException e) {
												System.out.println("SOMETHING WRONG");
												MyLogger.writeToLog("Exception ::", e);
											}
										}
									} else if (choice == 4) {

										boolean back = false;
										while (!back) {
											System.out.println("Please Choose According To Numbers: ");
											System.out.println("1. View all Vehicles");
											System.out.println("2. Update the Model");
											System.out.println("3. Update the License number (form xx-xxxxx)");
											System.out.println("4. Update the Price");
											System.out.println("5. Update the Status");
											System.out.println("6. back");

											try {

												int choice1 = scan.nextInt();
												if (choice1 == 1) {

													vauv.info();

												} else if (choice1 == 2) {

													vauv.info();
													try {

														System.out.println("Enter number of line: ");
														int lineNum = scan.nextInt();

														System.out.println("enter the new model: ");
														String newmodele = scan.next();

														vauv.updateModel(lineNum, newmodele);

													} catch (InputMismatchException e) {
														System.out.println("SOMETHING WRONG");
														MyLogger.writeToLog("Exception ::", e);
													}

												} else if (choice1 == 3) {

													vauv.info();
													try {

														System.out.println("Enter number of line: ");
														int lineNum = scan.nextInt();

														System.out.println("enter the License number: ");
														String newLicenseNum = scan.next();

														vauv.updateLicenseNum(lineNum, newLicenseNum);

													} catch (InputMismatchException e) {
														System.out.println("SOMETHING WRONG");
														MyLogger.writeToLog("Exception ::", e);
													}

												} else if (choice1 == 4) {

													vauv.info();
													try {

														System.out.println("Enter number of line: ");
														int lineNum = scan.nextInt();

														System.out.println("enter the new price: ");
														float newPrice = scan.nextFloat();

														vauv.updatePrice(lineNum, newPrice);

													} catch (InputMismatchException e) {
														System.out.println("SOMETHING WRONG");
														MyLogger.writeToLog("Exception ::", e);
													}

												} else if (choice1 == 5) {

													vauv.info();
													try {

														System.out.println("Enter number of line: ");
														int lineNum = scan.nextInt();

														System.out.println(
																"enter the new Status (Available – Rented – Maintenance): ");
														String newStatus = scan.next();

														vauv.updateStatus(lineNum, newStatus);

													} catch (InputMismatchException e) {
														System.out.println("SOMETHING WRONG");
														MyLogger.writeToLog("Exception ::", e);
													}

												} else if (choice1 == 6) {

													back = true;

												} else {

													System.out.println("Invalid Number");
												}

											} catch (InputMismatchException e) {
												System.out.println("SOMETHING WRONG");
												MyLogger.writeToLog("Exception ::", e);
											}
										}

									} else {

										System.out.println("Invalid Number");
									}

								} catch (InputMismatchException e) {
									System.out.println("SOMETHING WRONG");
									MyLogger.writeToLog("Exception ::", e);
								}
							}
						} else {
							System.out.println("Invalid name or password");
						}
					} else {
						System.out.println("Password not valid");

					}

				} else if (numOfChoice == 3) {

					try {

						System.out.println("Enter your name: ");
						String name = scan.next();

						System.out.println("Enter your password: ");
						String password = scan.next();

						if (PasswordPolicy.isValidPassword(password, policy)) {

							MaintenanceLogin main = new MaintenanceLogin();
							boolean validate = main.maintenanceLogin(name, password);

							if (validate == true) {
								MyLogger.writeToLog("Maintenance staff login Successfully useing username: " + name
										+ ", Password: " + password);

								System.out.println("Login Successfully");
								System.out.println("Welcome " + name);

								boolean exit = true;
								while (exit) {
									try {

										System.out.println("Please Choose According To Numbers: ");
										System.out.println("1. View Vehicles");
										System.out.println("2. Update Vehicles Status");
										System.out.println("3. Exit");

										int choice = scan.nextInt();
										ViewAndUpdateVehicles vauv = new ViewAndUpdateVehicles();

										if (choice == 1) {

											vauv.infoMaintenance();

										} else if (choice == 2) {

											vauv.infoMaintenance();
											try {

												System.out.println("Enter number of line: ");
												int lineNum = scan.nextInt();

												System.out.println("enter the new Status (Available – Maintenance): ");
												String newStatus = scan.next();

												vauv.updateStatus(lineNum, newStatus);

											} catch (InputMismatchException e) {
												System.out.println("SOMETHING WRONG");
												MyLogger.writeToLog("Exception ::", e);
											}

										} else if (choice == 3) {
											exit = false;
										} else {

											System.out.println("Invalid Number");
										}

									} catch (InputMismatchException e) {
										System.out.println("SOMETHING WRONG");
										MyLogger.writeToLog("Exception ::", e);
									}

								}
							} else {
								System.out.println("Invalid name or password");

							}

						} else {
							System.out.println("Password not valid");

						}

					} catch (InputMismatchException e) {
						System.out.println("SOMETHING WRONG");
						MyLogger.writeToLog("Exception ::", e);
					}

					//////////////////////////////////////////////////////// System Admin
					//////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////////////////
				} else if (numOfChoice == 4) {

					try {

						System.out.println("Enter your name: ");
						String name = scan.next();

						System.out.println("Enter your password: ");
						String password = scan.next();

						if (PasswordPolicy.isValidPassword(password, policy)) {

							AdminLogin admin = new AdminLogin();
							boolean validate = admin.adminLogin(name, password);

							if (validate == true) {
								MyLogger.writeToLog("Admin login Successfully useing username: " + name + ", Password: "
										+ password);

								System.out.println("Login Successfully");

								System.out.println("Welcome " + name);
								boolean exit = false;
								while (!exit) {
									try {

										System.out.println("Please Choose According To Numbers: ");
										System.out.println("1. Add Rental Agents");
										System.out.println("2. Remove Rental Agents");
										System.out.println("3. Update security policies");
										System.out.println("4. Exit");

										int choice = scan.nextInt();

/////////////////////////////////////////////////////
										if (choice == 1) {

											AddRentalAgents ara = new AddRentalAgents();
											try {
												ara.add();
											} catch (InputMismatchException e) {
												System.out.println("SOMETHING WRONG");
												MyLogger.writeToLog("Exception ::", e);
											}
////////////////////////////////////////////////////////
										} else if (choice == 2) {

											RemoveRentalAgent rra = new RemoveRentalAgent();
											try {

												rra.info();
												System.out.println("Enter number of line: ");
												int lineNum = scan.nextInt();

												System.out.println("enter the name: ");
												String nameAgent = scan.next();

												rra.remove(lineNum, nameAgent);

											} catch (InputMismatchException e) {
												System.out.println("SOMETHING WRONG");
												MyLogger.writeToLog("Exception ::", e);
											}

										} else if (choice == 3) {

											while (!exit) {
												try {
													System.out.println("Please Choose According To Numbers: ");
													System.out.println("1. Update password strength");
													System.out.println("2. Update number of attempted logins");
													System.out.println("3. Update number of attempted update info");
													System.out.println("4. lock/unlock an account");
													System.out.println("5. exit");
													int choiceNum = scan.nextInt();

													if (choiceNum == 1) {

														System.out.println("Enter minmum length for password: ");
														try {
															int minmumLingth = scan.nextInt();
														policy.setMinLength(minmumLingth);
														
														} catch (InputMismatchException e) {
															System.out.println("SOMETHING WRONG");
														}									
								
														
													} else if (choiceNum == 2) {

														System.out.println("Enter the number of attempted logins: ");
														numberOfAttemptedlogins = scan.nextInt();

													} else if (choiceNum == 3) {

														System.out
																.println("Enter the number of attempted update info: ");
														numberOfAttemptedUpdate = scan.nextInt();

													} else if (choiceNum == 4) {

														LouckAndUnlocked lu = new LouckAndUnlocked();

														lu.info();
														try {

															System.out.println("Enter number of line: ");
															int lineNum = scan.nextInt();

															System.out.println("1. Louck");
															System.out.println("2. Unlouck");
															int state = scan.nextInt();

															if (state == 1) {

																lu.updatestate(lineNum, "Yes");

															} else if (state == 2) {

																lu.updatestate(lineNum, "No");
															} else {
																System.out.println("WRONG NUMBER");
															}

														} catch (InputMismatchException e) {
															System.out.println("SOMETHING WRONG");
															MyLogger.writeToLog("Exception ::", e);
														}

													} else if (choiceNum == 5) {
														break;

													} else {

														System.out.println("Invalid Number");
													}

												} catch (InputMismatchException e) {
													System.out.println("SOMETHING WRONG");
													MyLogger.writeToLog("Exception ::", e);

												}

											}
										} else if (choice == 4) {

											exit = true;

										} else {
											System.out.println("Invalid Number");
										}

									} catch (InputMismatchException e) {
										System.out.println("SOMETHING WRONG");
										MyLogger.writeToLog("Exception ::", e);

									} catch (NoSuchElementException e) {
										System.out.println("SOMETHING WRONG");
										MyLogger.writeToLog("Exception ::", e);
									}

								}
							} else {
								System.out.println("Invalid name or password");
							}

						} else {
							System.out.println("Password not valid");

						}

					} catch (InputMismatchException e) {
						System.out.println("SOMETHING WRONG");
						MyLogger.writeToLog("Exception ::", e);
					}

				} else if (numOfChoice == 5) {
					exitSystem = false;
					scan.close();
				} else {

					System.out.println("Invalid Number");
				}

			} catch (InputMismatchException e) {
				System.out.println("SOMETHING WRONG");
				MyLogger.writeToLog("Exception ::", e);
				break;
			}

		}
		scan.close();
	}

}


