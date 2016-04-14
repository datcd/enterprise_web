/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Pham Tung
 */
public class Comment 
{
    private int _courseId;
    private int _cmrId;
    private String _content;

    public Comment() {
    }

    public int getCourseId() {
        return _courseId;
    }

    public void setCourseId(int _courseId) {
        this._courseId = _courseId;
    }

    public int getCmrId() {
        return _cmrId;
    }

    public void setCmrId(int _cmrId) {
        this._cmrId = _cmrId;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String _content) {
        this._content = _content;
    }
    
    
    
}
