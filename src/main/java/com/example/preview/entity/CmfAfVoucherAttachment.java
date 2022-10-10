package com.example.preview.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.beans.Transient;
import java.util.Date;

/*
 *com.example.preview.entity - 将在其中创建新类或接口的目标包的名称
 *preview - 当前项目的名称。
 *@author 24482 - 当前用户的登录名。
 *@data 2022/09/03
 */
public class CmfAfVoucherAttachment {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 7628867411053191595L;

    /**
     * 附件ID
     */
    private Long attachmentId;

    /**
     * 附件路径
     */
    private String attachmentPath;

    /**
     * 附件名称
     */
    private String attachmentName;

    /**
     * 凭证ID
     */
    private Long voucherId;

    /**
     * 来源
     */
    private String source;
    /**
     * 附件类型
     */
    private String fileTypeName;
    /**
     * uuid字段
     */
    private String uuid;

    /**
     * 签章文件状态
     */
    private String status;

    /**
     * 凭证ids
     */
    private String voucherIds;

    /**
     * 上传人名称
     */
    private String uploadPersonName;
    /**
     * 上传时间
     */
    private Date uploadTime;
    /**
     * 附件后缀
     */
    private String attachmentType;
    /**
     * 来源系统代码
     */
    private String systemCode;
    /**
     * 报账单号
     */
    private String billNo;
    /**
     * 单据ID (仅报账：报账单）
     */
    private Long billId;
    /**
     * 档案号
     */
    private String voucherBookNo;
    /**
     * 凭证号
     */
    private String voucherNo;
    /**
     * 档案大类
     */
    private String archiveType;
    /**
     * 凭证、资料类型
     */
    private String voucherTypeCode;
    /**
     * 资料名称
     */
    private String fileName;
    /**
     * 交易流水号
     */
    private String transactionNo;
    /**
     * 纳税申报表编号
     */
    private String originalFileNo;
    /**
     * 本方银行账号
     */
    private String bankAccountNo;

    /**
     * 文件内容
     */
    private String fileContent;

    /**
     * BOSS 收款编号
     */
    private String receiptNumber;

    /**
     * 批名
     */
    private String batchName;

    /**
     * 收款流水号
     */
    private String bankReceiptNumber;

    /**
     * boss 文件名
     */
    private String dataFileName;

    /**
     * 打印PDF标志
     */
    private String printContent;

    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    @XmlTransient
    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFileTypeName() {
        return fileTypeName;
    }

    public void setFileTypeName(String fileTypeName) {
        this.fileTypeName = fileTypeName;
    }

    @XmlTransient
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @XmlTransient
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVoucherIds() {
        return voucherIds;
    }

    public void setVoucherIds(String voucherIds) {
        this.voucherIds = voucherIds;
    }

    public String getUploadPersonName() {
        return uploadPersonName;
    }

    public void setUploadPersonName(String uploadPersonName) {
        this.uploadPersonName = uploadPersonName;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getVoucherBookNo() {
        return voucherBookNo;
    }

    public void setVoucherBookNo(String voucherBookNo) {
        this.voucherBookNo = voucherBookNo;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getArchiveType() {
        return archiveType;
    }

    public void setArchiveType(String archiveType) {
        this.archiveType = archiveType;
    }

    public String getVoucherTypeCode() {
        return voucherTypeCode;
    }

    public void setVoucherTypeCode(String voucherTypeCode) {
        this.voucherTypeCode = voucherTypeCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOriginalFileNo() {
        return originalFileNo;
    }

    public void setOriginalFileNo(String originalFileNo) {
        this.originalFileNo = originalFileNo;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getBankReceiptNumber() {
        return bankReceiptNumber;
    }

    public void setBankReceiptNumber(String bankReceiptNumber) {
        this.bankReceiptNumber = bankReceiptNumber;
    }

    public String getDataFileName() {
        return dataFileName;
    }

    public void setDataFileName(String dataFileName) {
        this.dataFileName = dataFileName;
    }

    public String getPrintContent() {
        return printContent;
    }

    public void setPrintContent(String printContent) {
        this.printContent = printContent;
    }
}
